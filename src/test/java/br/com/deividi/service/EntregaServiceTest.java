package br.com.deividi.service;

import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.StatusEntrega;
import br.com.deividi.domain.exception.EntregaStatusInvalidoException;
import br.com.deividi.repository.EntregaRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EntregaServiceTest {

    @Test
    void deveIniciarTransporteQuandoEntregaCriada() {
        Cliente cliente = new Cliente("Cliente Teste", "12345678909");
        Endereco endereco = new Endereco("SP", "Campinas", "Rua A", "13000000", 10);

        Entrega entrega = new Entrega(cliente, endereco);

        entrega.iniciarTransporte();

        assertEquals(StatusEntrega.EM_TRANSPORTE, entrega.getStatus());
    }

    @Test
    void naoDeveIniciarTransporteSeStatusInvalido() {

        Cliente cliente = new Cliente("Cliente Teste", "12345678909");
        Endereco endereco = new Endereco("SP", "Campinas", "Rua A", "13000000", 10);

        Entrega entrega = new Entrega(cliente, endereco);
        entrega.iniciarTransporte();

        assertThrows(EntregaStatusInvalidoException.class, entrega::iniciarTransporte);
    }

    @Test
    void naoDeveCancelarEntregaFinalizada() {
        Cliente cliente = new Cliente("Cliente Teste", "12345678909");
        Endereco endereco = new Endereco("SP", "Campinas", "Rua A", "13000000", 10);
        Entrega entrega = new Entrega(cliente, endereco);
        entrega.iniciarTransporte();
        entrega.finalizarEntrega();

        assertThrows(EntregaStatusInvalidoException.class, entrega::cancelarEntrega);
    }
}
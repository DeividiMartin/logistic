package br.com.deividi.domain;

import br.com.deividi.domain.exception.EntregaStatusInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class EntregaTest {

    @org.testng.annotations.Test
    void deveIniciarTransporteQuandoStatusForCriada() {

        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();

        Entrega entrega = new Entrega(cliente, endereco);

        entrega.iniciarTransporte();

        assertEquals(StatusEntrega.EM_TRANSPORTE, entrega.getStatus());
    }

    @Test
    void naoDeveIniciarTransporteSeStatusNaoForCriada() {

        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();

        Entrega entrega = new Entrega(cliente, endereco);
        entrega.iniciarTransporte();

        assertThrows(EntregaStatusInvalidoException.class, entrega::iniciarTransporte);
    }
}

package br.com.deividi.service;

import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.StatusEntrega;
import br.com.deividi.repository.EntregaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EntregaServiceTest {

    @Test
    void deveCriarEntregaComStatusCriada() {

        // mock do repository
        EntregaRepository repository = mock(EntregaRepository.class);

        EntregaService service = new EntregaService(repository);

        Cliente cliente = new Cliente("João", 12345678);
        Endereco endereco = new Endereco("RS", "Erechim", "Rua A", "99999999", 100);

        when(repository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Entrega entrega = service.criarEntrega(cliente, endereco);

        assertEquals(StatusEntrega.CRIADA, entrega.getStatus());
    }

    @Test
    void naoDeveIniciarTransporteSeStatusInvalido() {

        EntregaRepository repository = mock(EntregaRepository.class);
        EntregaService service = new EntregaService(repository);

        Cliente cliente = new Cliente("João", 12345678);
        Endereco endereco = new Endereco("RS", "Erechim", "Rua A", "99999999", 100);

        Entrega entrega = new Entrega(cliente, endereco);
        entrega.iniciarTransporte();
        entrega.finalizarEntrega();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(entrega));

        assertThrows(
                RuntimeException.class,
                () -> service.iniciarTransporte(1L)
        );
    }

}

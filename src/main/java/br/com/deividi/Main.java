package br.com.deividi;

import br.com.deividi.domain.Cliente;
import br.com.deividi.repository.InMemoryEntregaRepository;
import br.com.deividi.service.EntregaService;

public class Main {

    public static void main(String[] args) {

        var repository = new InMemoryEntregaRepository();
        var service = new EntregaService(repository);

        var cliente = new Cliente("João", "joao@email.com");

        var entrega = service.criarEntrega(cliente);

        service.iniciarTransporte(entrega.id());
        service.finalizarEntrega(entrega.id());

        System.out.println("Entrega finalizada com sucesso");
    }
}

package br.com.deividi.controller;
import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.service.EntregaService;


public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    public Entrega criarEntrega(
            String nomeCliente,
            Long cpf,
            String estado,
            String cidade,
            String rua,
            String cep,
            int numero
    ) {
        Cliente cliente = new Cliente(nomeCliente, cpf);
        Endereco endereco = new Endereco(estado, cidade, rua, cep, numero);

        return entregaService.criarEntrega(cliente, endereco);
    }

    public Entrega buscarEntrega(Long id) {
        return entregaService.buscarEntrega(id);
    }

    public void iniciarTransporte(Long entregaId) {
        entregaService.iniciarTransporte(entregaId);
    }

    public void finalizarEntrega(Long entregaId) {
        entregaService.finalizarEntrega(entregaId);
    }

    public void cancelarEntrega(Long entregaId) {
        entregaService.cancelarEntrega(entregaId);
    }
}

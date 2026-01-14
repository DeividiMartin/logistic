package br.com.deividi.controller;

import br.com.deividi.controller.dto.CriarEntregaRequest;
import br.com.deividi.controller.dto.EnderecoRequest;
import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.service.EntregaService;

public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    public Entrega criarEntrega(CriarEntregaRequest request) {
        EnderecoRequest enderecoRequest = request.getEndereco();
        Cliente cliente = new Cliente(
                request.getNomeCliente(),
                request.getCpf()
        );
        Endereco endereco = new Endereco(
                enderecoRequest.getEstado(),
                enderecoRequest.getCidade(),
                enderecoRequest.getRua(),
                enderecoRequest.getCep(),
                enderecoRequest.getNumero()
        );
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

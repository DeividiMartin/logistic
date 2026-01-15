package br.com.deividi.controller;

import br.com.deividi.controller.dto.CriarEntregaRequest;
import br.com.deividi.controller.dto.EnderecoRequest;
import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.service.EntregaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public Entrega criarEntrega(@RequestBody CriarEntregaRequest request) {
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

    @GetMapping("/{id}")
    public Entrega buscarEntrega(Long id) {
        return entregaService.buscarEntrega(id);
    }

    @PostMapping("/{id}/iniciar")
    public void iniciarTransporte(Long entregaId) {
        entregaService.iniciarTransporte(entregaId);
    }

    @PostMapping("/{id}/finalizar")
    public void finalizarEntrega(Long entregaId) {
        entregaService.finalizarEntrega(entregaId);
    }

    @PostMapping("/{id}/cancelar")
    public void cancelarEntrega(Long entregaId) {
        entregaService.cancelarEntrega(entregaId);
    }
}

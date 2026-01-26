package br.com.deividi.controller;

import br.com.deividi.controller.dto.CriarEntregaRequest;
import br.com.deividi.controller.dto.EnderecoRequest;
import br.com.deividi.controller.dto.EntregaResponse;
import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public Entrega criarEntrega(@RequestBody @Valid CriarEntregaRequest request) {
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
    public EntregaResponse buscarEntrega(@PathVariable Long id) {
        Entrega entrega = entregaService.buscarEntrega(id);
        return new EntregaResponse(entrega);
    }
    @PostMapping("/{id}/iniciar")
    public void iniciarTransporte(@PathVariable("id") Long entregaId) {
        entregaService.iniciarTransporte(entregaId);
    }

    @PostMapping("/{id}/finalizar")
    public void FinalizarTransporte(@PathVariable("id") Long entregaId) {
        entregaService.finalizarEntrega(entregaId);
    }

    @PostMapping("/{id}/cancelar")
    public void cancelarEntrega(@PathVariable ("id") Long entregaId) {
        entregaService.cancelarEntrega(entregaId);
    }
}

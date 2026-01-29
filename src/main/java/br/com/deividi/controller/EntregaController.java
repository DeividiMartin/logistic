package br.com.deividi.controller;

import br.com.deividi.controller.dto.CriarEntregaRequest;
import br.com.deividi.controller.dto.EnderecoRequest;
import br.com.deividi.controller.dto.EntregaResponse;
import br.com.deividi.controller.mapper.EntregaMapper;
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
    public EntregaResponse criarEntrega(@RequestBody @Valid CriarEntregaRequest request) {

        Cliente cliente = new Cliente(
                request.getNomeCliente(),
                request.getCpf()
        );

        Endereco endereco = new Endereco(
                request.getEndereco().getEstado(),
                request.getEndereco().getCidade(),
                request.getEndereco().getRua(),
                request.getEndereco().getCep(),
                request.getEndereco().getNumero()
        );

        Entrega entrega = entregaService.criarEntrega(cliente, endereco);

        return EntregaMapper.toResponse(entrega);
    }


    @GetMapping("/{id}")
    public EntregaResponse buscarEntrega(@PathVariable Long id) {
        Entrega entrega = entregaService.buscarEntrega(id);
        return EntregaMapper.toResponse(entrega);
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

package br.com.deividi.controller;

import br.com.deividi.service.EntregaService;

public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
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

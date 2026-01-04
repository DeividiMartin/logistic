package br.com.deividi.service;

import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Entrega;
import br.com.deividi.repository.EntregaRepository;

public class EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega criarEntrega(Cliente cliente) {
        Entrega entrega = new Entrega(cliente);
        entregaRepository.salvar(entrega);
        return entrega;
    }

    public void iniciarTransporte(Entrega entrega) {
        entrega.iniciarTransporte();
    }

    public void finalizarEntrega(Entrega entrega) {
        entrega.finalizarEntrega();
    }

    public void cancelarEntrega(Entrega entrega) {
        entrega.cancelar();
    }
}

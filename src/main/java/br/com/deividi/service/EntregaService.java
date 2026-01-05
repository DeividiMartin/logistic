package br.com.deividi.service;

import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.Cliente;
import br.com.deividi.repository.EntregaRepository;
import br.com.deividi.exception.RegraNegocioException;

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

    public void iniciarTransporte(Long entregaId) {
        Entrega entrega = buscarEntrega(entregaId);
        entrega.iniciarTransporte();
    }

    public void finalizarEntrega(Long entregaId) {
        Entrega entrega = buscarEntrega(entregaId);
        entrega.finalizarEntrega();
    }

    public void cancelarEntrega(Long entregaId) {
        Entrega entrega = buscarEntrega(entregaId);
        entrega.cancelar();
    }

    private Entrega buscarEntrega(Long entregaId) {
        return entregaRepository.buscarPorId(entregaId)
                .orElseThrow(() -> new RegraNegocioException("Entrega não encontrada"));
    }
}

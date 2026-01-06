package br.com.deividi.service;

import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.exception.RegraNegocioException;
import br.com.deividi.repository.EntregaRepository;

public class EntregaService {

    private final EntregaRepository repository;

    public EntregaService(EntregaRepository repository) {
        this.repository = repository;
    }

    public Entrega criarEntrega(Cliente cliente) {
        Entrega entrega = new Entrega(cliente);
        repository.salvar(entrega);
        return entrega;
    }

    public void iniciarTransporte(Long entregaId) {
        Entrega entrega = buscar(entregaId);
        entrega.iniciarTransporte();
    }

    public void finalizarEntrega(Long entregaId) {
        Entrega entrega = buscar(entregaId);
        entrega.finalizarEntrega();
    }

    public void cancelarEntrega(Long entregaId) {
        Entrega entrega = buscar(entregaId);
        entrega.cancelar();
    }

    private Entrega buscar(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RegraNegocioException("Entrega não encontrada"));
    }
}

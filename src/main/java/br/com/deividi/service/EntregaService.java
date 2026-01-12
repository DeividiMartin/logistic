package br.com.deividi.service;

import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.exception.RegraNegocioException;
import br.com.deividi.repository.EntregaRepository;

import java.util.Optional;

public class EntregaService {


    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega criarEntrega(Cliente cliente, Endereco endereco) {
        Entrega entrega = new Entrega(cliente, endereco);
        entregaRepository.salvar(entrega);
        return entrega;
    }

    public Entrega buscarEntrega(Long id) {
        Optional<Entrega> optionalEntrega = entregaRepository.buscaPorId(id);

        if (optionalEntrega.isEmpty()) {
            throw new RegraNegocioException("Entrega não encontrada");
        }

        return optionalEntrega.get();
    }


    public void iniciarTransporte(Long entregaId) {
        Entrega entrega = buscarEntrega(entregaId);
        entrega.iniciarTransporte();
        entregaRepository.atualizar(entrega);
    }

    public void finalizarEntrega(Entrega entrega){
        entrega.finalizarEntrega();
        entregaRepository.atualizar(entrega);
    }

    public void cancelarEntrega(Entrega entrega){
        entrega.cancelarEntrega();
        entregaRepository.atualizar(entrega);
    }


}

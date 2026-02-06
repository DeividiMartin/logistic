package br.com.deividi.service;

import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Endereco;
import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.exception.RegraNegocioException;
import br.com.deividi.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;
    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega criarEntrega(Cliente cliente, Endereco endereco) {
        Entrega entrega = new Entrega(cliente, endereco);
        return entregaRepository.save(entrega);
    }

    public Entrega buscarEntrega(Long id) {
        return entregaRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Entrega não encontrada"));
    }

    public void iniciarTransporte(Long entregaId) {
        Entrega entrega = buscarEntrega(entregaId);
        entrega.iniciarTransporte();
        entregaRepository.save(entrega);
    }

    public void finalizarEntrega(Long entregaId){
        Entrega entrega = buscarEntrega(entregaId);
        entrega.finalizarEntrega();
        entregaRepository.save(entrega);
    }

    public void cancelarEntrega(Long entregaId){
        Entrega entrega = buscarEntrega(entregaId);
        entrega.cancelarEntrega();
        entregaRepository.save(entrega);
    }

}

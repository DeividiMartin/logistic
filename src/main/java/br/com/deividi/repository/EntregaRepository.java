package br.com.deividi.repository;

import br.com.deividi.domain.Entrega;

import java.util.Optional;

public interface EntregaRepository {

    void salvar(Entrega entrega);

    Optional<Entrega> buscarPorId(Long id);
}

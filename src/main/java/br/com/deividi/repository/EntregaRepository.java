package br.com.deividi.repository;

import br.com.deividi.domain.Entrega;

import java.util.Optional;
import java.util.UUID;

public interface EntregaRepository {

    void salvar(Entrega entrega);

    Optional<Entrega> buscarPorId(UUID id);
}

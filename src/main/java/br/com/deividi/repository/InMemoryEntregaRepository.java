package br.com.deividi.repository;

import br.com.deividi.domain.Entrega;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryEntregaRepository implements EntregaRepository {

    private final Map<Long, Entrega> banco = new HashMap<>();
    private Long contador = 1L;

    @Override
    public void salvar(Entrega entrega) {
        if (entrega.id() == null) {
            entrega.definirId(contador++);
        }
        banco.put(entrega.id(), entrega);
    }

    @Override
    public Optional<Entrega> buscarPorId(Long id) {
        return Optional.ofNullable(banco.get(id));
    }
}

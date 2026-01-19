package br.com.deividi.repository;

import br.com.deividi.domain.Entrega;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class EntregaRepositoryEmMemoria implements EntregaRepository{

    private Long proximoId = 1L;
    private final Map<Long, Entrega> banco = new HashMap<>();



    @Override
    public void salvar(Entrega entrega) {
        if (entrega == null) {
            throw new IllegalArgumentException("Entrega não pode ser nula");
        }
        Long idGerado = proximoId;
        proximoId++;
        entrega.definirId(idGerado);
        banco.put(idGerado, entrega);
    }

    @Override
    public Optional<Entrega> buscaPorId(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        Entrega entrega = banco.get(id);
        return Optional.ofNullable(entrega);
    }

    @Override
    public void atualizar(Entrega entrega) {

        if (entrega == null) {
            throw new IllegalArgumentException("Entrega não pode ser nula");
        }

        if (entrega.getId() == null) {
            throw new IllegalArgumentException("Entrega sem ID não pode ser atualizada");
        }

        if (!banco.containsKey(entrega.getId())) {
            throw new IllegalArgumentException("Entrega não existe para atualização");
        }

        banco.put(entrega.getId(), entrega);
    }

}

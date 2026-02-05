package br.com.deividi.repository;

import br.com.deividi.domain.Entrega;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}

package br.com.deividi;

import br.com.deividi.domain.*;
import br.com.deividi.repository.EntregaRepository;
import br.com.deividi.repository.EntregaRepositoryEmMemoria;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Criar o repositório (simula banco)
        EntregaRepository entregaRepository = new EntregaRepositoryEmMemoria();

        // 2️⃣ Criar cliente
        Cliente cliente = new Cliente("Deivid", 12345678901L);

        // 3️⃣ Criar endereço
        Endereco endereco = new Endereco(
                "Rua das Flores",
                "100",
                "Centro",
                "99712501",
                515

        );

        // 4️⃣ Criar entrega
        Entrega entrega = new Entrega(cliente, endereco);

        // 5️⃣ Salvar entrega
        entregaRepository.salvar(entrega);

        Long idEntrega = entrega.getId();
        System.out.println("Entrega criada com ID: " + idEntrega);
        System.out.println("Status inicial: " + entrega.getStatus());

        // 6️⃣ Buscar entrega
        Entrega entregaBuscada = entregaRepository.buscaPorId(idEntrega)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada"));

        System.out.println("Entrega buscada, status: " + entregaBuscada.getStatus());

        // 7️⃣ Iniciar transporte
        entregaBuscada.iniciarTransporte();
        entregaRepository.atualizar(entregaBuscada);

        System.out.println("Status após iniciar transporte: " + entregaBuscada.getStatus());

        // 8️⃣ Finalizar entrega
        entregaBuscada.finalizarEntrega();
        entregaRepository.atualizar(entregaBuscada);

        System.out.println("Status final: " + entregaBuscada.getStatus());
    }
}

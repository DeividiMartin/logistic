package br.com.deividi.controller.mapper;

import br.com.deividi.controller.dto.EntregaResponse;
import br.com.deividi.domain.Entrega;

public class EntregaMapper {

    public static EntregaResponse toResponse(Entrega entrega) {
        EntregaResponse response = new EntregaResponse();
        response.setId(entrega.getId());
        response.setStatus(entrega.getStatus());
        response.setNomeCliente(entrega.getCliente().getNome());
        response.setCpf(entrega.getCliente().getCpf());
        response.setEstado(entrega.getEndereco().getEstado());
        response.setCidade(entrega.getEndereco().getCidade());
        response.setRua(entrega.getEndereco().getRua());
        response.setCep(entrega.getEndereco().getCep());
        response.setNumero(entrega.getEndereco().getNumero());
        return response;
    }
}

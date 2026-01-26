package br.com.deividi.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CriarEntregaRequest {

    @NotBlank(message = "Nome do cliente é obrigatório")
    private String nomeCliente;

    @NotNull(message = "CPF é obrigatório")
    private Long cpf;

    @NotNull(message = "Endereço é obrigatório")
    @Valid
    private EnderecoRequest endereco;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Long getCpf() {
        return cpf;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }
}

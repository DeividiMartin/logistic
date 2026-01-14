package br.com.deividi.controller.dto;

public class CriarEntregaRequest {

    private String nomeCliente;
    private Long cpf;
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

package br.com.deividi.controller.dto;

public class EnderecoRequest {

    private String estado;
    private String cidade;
    private String rua;
    private String cep;
    private int numero;

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }
}

package br.com.deividi.domain;

public class Endereco {

    private final String rua;
    private final String cidade;

    public Endereco(String rua, String cidade) {
        if (rua == null || rua.isBlank()) {
            throw new IllegalArgumentException("Rua inválida");
        }
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade inválida");
        }
        this.rua = rua;
        this.cidade = cidade;
    }

    public String rua() {
        return rua;
    }

    public String cidade() {
        return cidade;
    }
}

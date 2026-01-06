package br.com.deividi.domain;

public class Cliente {

    private final String nome;
    private final String email;

    public Cliente(String nome, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.nome = nome;
        this.email = email;
    }

    public String nome() {
        return nome;
    }

    public String email() {
        return email;
    }
}

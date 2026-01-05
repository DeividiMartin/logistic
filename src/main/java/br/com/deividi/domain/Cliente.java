package br.com.deividi.domain;

public class Cliente {

    private Long id;
    private String nome;
    private String documento;

    public Cliente(Long id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }
}

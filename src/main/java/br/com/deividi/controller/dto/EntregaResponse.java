package br.com.deividi.controller.dto;

import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.StatusEntrega;

public class EntregaResponse {

    private Long id;
    private StatusEntrega status;

    private String nomeCliente;
    private Long cpf;

    private String estado;
    private String cidade;
    private String rua;
    private String cep;
    private int numero;

    public EntregaResponse(Entrega entrega) {
        this.id = entrega.getId();
        this.status = entrega.getStatus();

        this.nomeCliente = entrega.getCliente().getNome();
        this.cpf = entrega.getCliente().getCpf();

        this.estado = entrega.getEndereco().getEstado();
        this.cidade = entrega.getEndereco().getCidade();
        this.rua = entrega.getEndereco().getRua();
        this.cep = entrega.getEndereco().getCep();
        this.numero = entrega.getEndereco().getNumero();
    }

    public Long getId() {
        return id;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Long getCpf() {
        return cpf;
    }

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

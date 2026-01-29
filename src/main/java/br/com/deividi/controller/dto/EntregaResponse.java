package br.com.deividi.controller.dto;

import br.com.deividi.domain.Entrega;
import br.com.deividi.domain.StatusEntrega;

public class EntregaResponse {

    private Long id;
    private StatusEntrega status;
    private String nomeCliente;
    private long cpf;
    private String estado;
    private String cidade;
    private String rua;
    private String cep;
    private int numero;

    public EntregaResponse() {
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "EntregaResponse{" +
                "cpf=" + cpf +
                ", nomeCliente='" + nomeCliente + '\'' +
                '}';
    }
}

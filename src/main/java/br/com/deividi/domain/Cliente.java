package br.com.deividi.domain;

import br.com.deividi.domain.exception.RegraNegocioException;

public class Cliente {

    private String nome;
    private long cpf;

    public Cliente(String nome, long cpf) {
        validaNome(nome);
        validaCPF(cpf);
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void alterarNome(String novoNome) {
        validaNome(novoNome);
        this.nome = novoNome;
    }

    private void validaNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new RegraNegocioException("Nome é obrigatorio!");
        }
    }
    private void validaCPF(long cpf) {
        if (cpf <= 0){
            throw new RegraNegocioException("CPF invalido!");
        }
    }
}

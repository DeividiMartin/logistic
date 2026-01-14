package br.com.deividi.domain;

import br.com.deividi.domain.exception.RegraNegocioException;

public class Endereco {

    private String estado;
    private String cidade;
    private String rua;
    private String cep;
    private int numero;

    public Endereco(String estado, String cidade, String rua, String cep, int numero) {
        validarTexto(estado, "estado");
        validarTexto(cidade, "cidade");
        validarTexto(rua, "rua");
        validarCep(cep);
        validarNumero(numero);
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
    }

    private void validarTexto(String valor, String campo){
        if(valor == null || valor.isBlank()){
            throw new RegraNegocioException(campo + " é obrigatorio!");
        }

    }
    private void validarNumero(long numero){
        if(numero <= 0){
            throw new RegraNegocioException("Numero do endereço é invalido!");
        }
    }
    private void validarCep(String cep){
        if(cep == null || cep.isBlank()){
            throw new RegraNegocioException("Cep obrigatorio!");
        }
        String cepNumeros = cep.replaceAll("\\D","");
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

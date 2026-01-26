package br.com.deividi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnderecoRequest {

    @NotBlank(message = "Estado é obrigatório")
    private String estado;

    @NotBlank(message = "Cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "Rua é obrigatória")
    private String rua;

    @NotBlank(message = "CEP é obrigatório")
    @Size(min = 8, max = 8, message = "CEP deve ter 8 dígitos")
    private String cep;

    @NotNull(message = "Número é obrigatório")
    private Integer numero;

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

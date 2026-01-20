package br.com.deividi.controller.exception;

public class ApiError {

    private int status;
    private String erro;

    public ApiError(int status, String erro) {
        this.status = status;
        this.erro = erro;
    }

    public int getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }
}

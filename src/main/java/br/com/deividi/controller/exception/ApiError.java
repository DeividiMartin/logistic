package br.com.deividi.controller.exception;

public class ApiError {

    private int status;
    private Object erro;

    public ApiError(int status, Object erro) {
        this.status = status;
        this.erro = erro;
    }

    public int getStatus() {
        return status;
    }

    public Object getErro() {
        return erro;
    }
}

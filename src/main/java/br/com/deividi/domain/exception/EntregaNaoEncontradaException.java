package br.com.deividi.domain.exception;

public class EntregaNaoEncontradaException extends RegraNegocioException {

    public EntregaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
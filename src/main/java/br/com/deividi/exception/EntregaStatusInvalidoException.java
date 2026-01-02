package br.com.deividi.exception;

import br.com.deividi.exception.RegraNegocioException;

public class EntregaStatusInvalidoException extends RegraNegocioException {

    public EntregaStatusInvalidoException(String mensagem) {
        super(mensagem);
    }
}

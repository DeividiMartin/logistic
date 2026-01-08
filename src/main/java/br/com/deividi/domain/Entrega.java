package br.com.deividi.domain;

import br.com.deividi.domain.exception.EntregaStatusInvalidoException;
import br.com.deividi.domain.exception.RegraNegocioException;

public class Entrega {

    private StatusEntrega status;
    private Cliente cliente;
    private Endereco endereco;

    public Entrega(Cliente cliente, Endereco endereco) {
        validarCliente(cliente);
        validarEndereco(endereco);

        this.cliente = cliente;
        this.endereco = endereco;
        this.status = StatusEntrega.CRIADA;
    }

    public void iniciarTransporte() {
        if (status != StatusEntrega.CRIADA) {
            throw new EntregaStatusInvalidoException(
                    "Entrega só pode iniciar transporte se estiver CRIADA"
            );
        }
        this.status = StatusEntrega.EM_TRANSPORTE;
    }

    public void finalizarEntrega() {
        if (status != StatusEntrega.EM_TRANSPORTE) {
            throw new EntregaStatusInvalidoException(
                    "Entrega só pode ser finalizada se estiver EM_TRANSPORTE"
            );
        }
        this.status = StatusEntrega.FINALIZADA;
    }

    public void cancelar() {
        if (status == StatusEntrega.FINALIZADA) {
            throw new EntregaStatusInvalidoException(
                    "Entrega finalizada não pode ser cancelada"
            );
        }
        this.status = StatusEntrega.CANCELADA;
    }

    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new RegraNegocioException("Cliente é obrigatório");
        }
    }

    private void validarEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new RegraNegocioException("Endereço é obrigatório");
        }
    }

    public StatusEntrega getStatus() {
        return status;
    }
}

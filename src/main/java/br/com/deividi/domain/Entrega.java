package br.com.deividi.domain;

import br.com.deividi.exception.EntregaStatusInvalidoException;

import java.util.UUID;

public class Entrega {

    private UUID id;
    private Cliente cliente;
    private StatusEntrega status;

    public Entrega(Cliente cliente) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.status = StatusEntrega.CRIADA;
    }

    public UUID getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void iniciarTransporte() {
        if (this.status != StatusEntrega.CRIADA) {
            throw new EntregaStatusInvalidoException(
                    "Entrega só pode iniciar transporte se estiver CRIADA"
            );
        }
        this.status = StatusEntrega.EM_TRANSPORTE;
    }

    public void finalizarEntrega() {
        if (this.status != StatusEntrega.EM_TRANSPORTE) {
            throw new EntregaStatusInvalidoException(
                    "Entrega só pode ser finalizada se estiver EM_TRANSPORTE"
            );
        }
        this.status = StatusEntrega.ENTREGUE;
    }

    public void cancelar() {
        if (this.status == StatusEntrega.ENTREGUE) {
            throw new EntregaStatusInvalidoException(
                    "Entrega ENTREGUE não pode ser cancelada"
            );
        }
        this.status = StatusEntrega.CANCELADA;
    }

}

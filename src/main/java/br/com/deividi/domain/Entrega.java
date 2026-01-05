package br.com.deividi.domain;

import br.com.deividi.exception.EntregaStatusInvalidoException;

public class Entrega {

    private Long id;
    private Cliente cliente;
    private StatusEntrega status;

    public Entrega(Cliente cliente) {
        this.cliente = cliente;
        this.status = StatusEntrega.CRIADA;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void iniciarTransporte() {
        if (status != StatusEntrega.CRIADA) {
            throw new EntregaStatusInvalidoException("Entrega não pode iniciar transporte");
        }
        status = StatusEntrega.EM_TRANSPORTE;
    }

    public void finalizarEntrega() {
        if (status != StatusEntrega.EM_TRANSPORTE) {
            throw new EntregaStatusInvalidoException("Entrega não pode ser finalizada");
        }
        status = StatusEntrega.ENTREGUE;
    }

    public void cancelar() {
        if (status == StatusEntrega.ENTREGUE) {
            throw new EntregaStatusInvalidoException("Entrega já foi finalizada");
        }
        status = StatusEntrega.CANCELADA;
    }
}

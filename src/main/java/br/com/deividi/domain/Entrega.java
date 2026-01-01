package br.com.deividi.domain;

public class Entrega {


    private Cliente cliente;
    private StatusEntrega status;

    public Entrega(Cliente cliente) {
        this.cliente = cliente;
        this.status = StatusEntrega.CRIADA;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void iniciarTransporte() {
        if (this.status != StatusEntrega.CRIADA) {
            throw new IllegalStateException(
                    "Entrega só pode iniciar transporte se estiver CRIADA"
            );
        }
        this.status = StatusEntrega.EM_TRANSPORTE;
    }

    public void finalizarEntrega() {
        if (this.status != StatusEntrega.EM_TRANSPORTE) {
            throw new IllegalStateException(
                    "Entrega só pode ser finalizada se estiver EM_TRANSPORTE"
            );
        }
        this.status = StatusEntrega.ENTREGUE;
    }

    public void cancelar() {
        if (this.status == StatusEntrega.ENTREGUE) {
            throw new IllegalStateException(
                    "Entrega ENTREGUE não pode ser cancelada"
            );
        }
        this.status = StatusEntrega.CANCELADA;
    }




}

package br.com.deividi.domain;

import br.com.deividi.domain.exception.EntregaStatusInvalidoException;

public class Entrega {

    private Long id;
    private final Cliente cliente;
    private StatusEntrega status;

    public Entrega(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório");
        }
        this.cliente = cliente;
        this.status = StatusEntrega.CRIADA;
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
        status = StatusEntrega.FINALIZADA;
    }

    public void cancelar() {
        if (status == StatusEntrega.FINALIZADA) {
            throw new EntregaStatusInvalidoException("Entrega finalizada não pode ser cancelada");
        }
        status = StatusEntrega.CANCELADA;
    }

    public void definirId(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }

    public StatusEntrega status() {
        return status;
    }

    public Cliente cliente() {
        return cliente;
    }
}

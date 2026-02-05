package br.com.deividi.domain;

import br.com.deividi.domain.exception.EntregaStatusInvalidoException;
import br.com.deividi.domain.exception.RegraNegocioException;
import jakarta.persistence.*;

@Entity
@Table(name = "entregas")
public class Entrega {

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @ManyToOne
    private Cliente cliente;

    @Embedded
    private Endereco endereco;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    protected Entrega() {

    }

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

    public void cancelarEntrega() {
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

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}

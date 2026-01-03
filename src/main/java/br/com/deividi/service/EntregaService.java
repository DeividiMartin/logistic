package br.com.deividi.service;

import br.com.deividi.domain.Cliente;
import br.com.deividi.domain.Entrega;

public class EntregaService {

    public Entrega criarEntrega(Cliente cliente) {
        return new Entrega(cliente);
    }

    public void iniciarTransporte(Entrega entrega) {
        entrega.iniciarTransporte();
    }

    public void finalizarEntrega(Entrega entrega) {
        entrega.finalizarEntrega();
    }

    public void cancelarEntrega(Entrega entrega) {
        entrega.cancelar();
    }
}

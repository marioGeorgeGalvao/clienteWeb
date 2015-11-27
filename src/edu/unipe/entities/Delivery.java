package edu.unipe.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Delivery extends Pedido {

    private double trocoPara;

    @ManyToOne
    private Cliente cliente;

    public double getTrocoPara() {
        return trocoPara;
    }

    public void setTrocoPara(double trocoPara) {
        this.trocoPara = trocoPara;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

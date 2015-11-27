package edu.unipe.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
public abstract class Pedido {

    @Id
    private long id;

    private String data;

    private String status;

    @ManyToOne
    private Cardapio cardapio;

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}




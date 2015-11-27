package edu.unipe.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class ItemCardapio {

    @Id
    @GeneratedValue
    private Long id;
    private int quantidade;
    private double preco;

    @OneToMany
    private Collection<Pedido> pedidos;


}

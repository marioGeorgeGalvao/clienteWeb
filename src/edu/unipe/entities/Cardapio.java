package edu.unipe.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity
public class Cardapio {

    @Id
    private long Id;

    private String nome;

    private double preco;

    @OneToMany
    private Collection<ItemCardapio> itensCardapio;



}

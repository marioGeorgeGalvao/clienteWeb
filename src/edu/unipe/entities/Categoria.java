package edu.unipe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity
public class Categoria extends AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @OneToMany
    private Collection<Cardapio> cardapios;


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setCardapios(Collection<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }
}

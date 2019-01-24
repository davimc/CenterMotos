package model;

import javax.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    @ManyToOne
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }


    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Modelo(Marca marca, String nome) {
        this.marca = marca;
        this.nome = nome;
    }
}

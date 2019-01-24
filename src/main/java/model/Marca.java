package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }


    @OneToMany
    private List<Modelo> modelos;

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }



    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public Marca(String nome, List<Modelo> modelos) {
        this.nome = nome;
        this.modelos = modelos;
    }


}

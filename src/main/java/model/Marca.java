package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="marca")
public class Marca {
    @Id @GeneratedValue
    private long id;
    @OneToMany
    private List<Modelo> modelos;
    String nome;

    public Marca(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

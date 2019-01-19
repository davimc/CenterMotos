package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="peca")
public class Peca {
    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(mappedBy = "pecas",targetEntity = Servico.class,fetch = FetchType.LAZY)
    private List<Servico> servicos;
    private String nome;
    private double preco;
    private int quantidade;
    private String marca;
    @ElementCollection @Column(length = 20, name="peca_modelos")
    private List<String> modelos;

    public Peca(String nome, double preco, int quantidade, String marca, List<String> modelos) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
        this.modelos = modelos;
    }

    public long getId() {
        return id;
    }

//    public List<Servico> getServicos() {
//        return servicos;
//    }
//
//    public void setServicos(List<Servico> servicos) {
//        this.servicos = servicos;
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<String> getModelos() {
        return modelos;
    }

    public void setModelos(List<String> modelos) {
        this.modelos = modelos;
    }
}

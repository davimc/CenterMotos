package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "peca")
public class Peca {
    @Id
    @GeneratedValue
    private long id;


    public long getId() {
        return id;
    }


    @ManyToMany(mappedBy = "pecas", targetEntity = Venda.class, fetch = FetchType.LAZY)
    private List<Venda> vendas;

    public List<Venda> getServicos() {
        return vendas;
    }

    public void setServicos(List<Venda> vendas) {
        this.vendas = vendas;
    }


    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    private double preco;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    @ElementCollection
    @Column(length = 20, name = "peca_modelos")
    private List<String> modelos;

    public List<String> getModelos() {
        return modelos;
    }

    public void setModelos(List<String> modelos) {
        this.modelos = modelos;
    }


    public Peca(String nome, double preco, int quantidade, String marca, List<String> modelos) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
        this.modelos = modelos;
    }
}

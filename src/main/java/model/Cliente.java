package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }



    @OneToMany(mappedBy = "cliente", targetEntity = Moto.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Moto> motos;

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

    @OneToMany(mappedBy="cliente", targetEntity = Venda.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Venda> vendas;

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    private String telefone;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    private double conta;

    public double getConta() {
        return conta;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }



    @Temporal(TemporalType.DATE)
    private Calendar dataCadastro;

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


    public Cliente(){}
    public Cliente(String nome, String tel, String end) {
        this.nome = nome;
        this.telefone = tel;
        this.endereco = end;
        this.conta = 0.0;
        this.dataCadastro = Calendar.getInstance();

    }

    public Cliente(String nome, String tel, String end, double conta) {
        this.nome = nome;
        this.telefone = tel;
        this.endereco = end;
        this.conta = conta;
        this.dataCadastro = Calendar.getInstance();
    }
    public void fazerConta(double preco){
        setConta(getConta()+preco);
    }
}

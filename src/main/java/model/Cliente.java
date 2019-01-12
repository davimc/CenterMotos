package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<Moto> motos;
    private String nome;
    private String telefone;
    private String endereco;
    private double conta;
    @Temporal(TemporalType.DATE)
    private Calendar dataCadastro;

    public Cliente(String nome, String tel, String end){
        this.nome = nome;
        this.telefone = tel;
        this.endereco = end;
        this.conta = 0.0;
        this.dataCadastro = Calendar.getInstance();

    }
    public Cliente(String nome, String tel, String end, double conta){
        this.nome = nome;
        this.telefone = tel;
        this.endereco = end;
        this.conta = conta;
        this.dataCadastro = Calendar.getInstance();
    }
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getConta() {
        return conta;
    }

    public void setConta(double conta) {
        this.conta = conta;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

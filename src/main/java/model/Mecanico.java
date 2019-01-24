package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "mecanico")
public class Mecanico {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }


    @OneToMany(mappedBy = "mecanico", targetEntity = Servico.class, fetch = FetchType.LAZY)
    private List<Servico> servicos;

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }


    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Temporal(TemporalType.DATE)
    private Calendar dataVinculacao, dataDesvinculacao;

    public Calendar getDataVinculacao() {
        return dataVinculacao;
    }

    public void setDataVinculacao(Calendar dataVinculacao) {
        this.dataVinculacao = dataVinculacao;
    }

    public Calendar getDataDesvinculacao() {
        return dataDesvinculacao;
    }

    public void setDataDesvinculacao(Calendar dataDesvinculacao) {
        this.dataDesvinculacao = dataDesvinculacao;
    }


    private boolean status;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public Mecanico(String nome, Calendar dataVinculacao) {
        this.nome = nome;
        this.dataVinculacao = dataVinculacao;
        this.status = true;
    }











}

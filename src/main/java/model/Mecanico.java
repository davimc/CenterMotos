package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Mecanico {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "servico")
    private List<Servico> servicos;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Calendar dataVinculacao, dataDesvinculacao;
    private String status;

    public long getId() {
        return id;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

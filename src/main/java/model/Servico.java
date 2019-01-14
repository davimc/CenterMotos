package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Servico {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Moto moto;
    @ManyToOne
    private Mecanico mecanico;
    @ManyToMany
    private List<Peca> pecas;

    public long getId() {
        return id;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Calendar dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Calendar getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(Calendar dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    @Temporal(TemporalType.DATE)
    private Calendar dataInicio, dataTermino, dataPrevisao;
    private String status;
    private double orcamento;
    private double precoFinal;


}

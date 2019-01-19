package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_moto")
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Moto moto;
    @ManyToOne
    @JoinColumn(name="id_mecanico")
    private Mecanico mecanico;
    @ManyToMany
    @JoinTable(name="servicos_pecas",joinColumns =
            {@JoinColumn(name="id_servico")},inverseJoinColumns=
            {@JoinColumn(name="id_peca")})
    private List<Peca> pecas;
    @Temporal(TemporalType.DATE)
    private Calendar dataInicio, dataTermino, dataPrevisao;
    private String status;//ATIVO, FINALIZADO, CANCELADO
    private boolean isPago;
    private double orcamento;
    private double precoFinal;

    public Servico(Moto moto, Mecanico mecanico, Calendar dataInicio, Calendar dataPrevisao, double orcamento) {
        //this.moto = moto;
        this.mecanico = mecanico;
        this.dataInicio = dataInicio;
        this.dataPrevisao = dataPrevisao;
        this.status = "ATIVO";
        this.isPago = false;
        this.orcamento = orcamento;
    }

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

    public void cancelaServico() {
        this.status = "CANCELADO";
        this.dataTermino = Calendar.getInstance();
    }
    public void finalizaServico(){
        this.status = "FINALIZADO";
        this.dataTermino = Calendar.getInstance();
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
}

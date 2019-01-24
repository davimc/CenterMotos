package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMoto")
//    @Fetch(FetchMode.JOIN)
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Moto moto;

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }


    @ManyToOne
    @JoinColumn(name = "idMecanico")
    private Mecanico mecanico;

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }



    @Temporal(TemporalType.DATE)
    private Calendar dataInicio, dataTermino, dataPrevisao;

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


    private boolean isCancelado;

    public boolean isCancelado() {
        return isCancelado;
    }

    public void setCancelado(boolean cancelado) {
        isCancelado = cancelado;
    }


    private boolean isFinalizado;

    public boolean isFinalizado() {
        return isFinalizado;
    }

    public void setFinalizado(boolean finalizado) {
        isFinalizado = finalizado;
    }


    private boolean isPago;


    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        isPago = pago;
    }

    private double orcamento;

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }


    private double precoFinal;

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;

    }


    private double valorServico;

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }


    @ElementCollection
    @Column(length = 20, name = "peca_modelos")
    private List<String> servicos;

    public List<String> getServicos() {
        return servicos;
    }

    public void setServicos(List<String> servicos) {
        this.servicos = servicos;
    }

    public Servico(Moto moto, Mecanico mecanico, Calendar dataInicio, Calendar dataPrevisao, double orcamento) {
        this.moto = moto;
        this.mecanico = mecanico;
        this.dataInicio = dataInicio;
        this.dataPrevisao = dataPrevisao;
        this.isCancelado = false;
        this.isFinalizado = false;
        this.isPago = false;
        this.orcamento = orcamento;
    }

}

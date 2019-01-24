package model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Venda {
    /*atributos e seus getters e setters*/
    @Id @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }
    @ManyToMany
    @JoinTable(name = "vendas_pecas", joinColumns =
            {@JoinColumn(name = "idVenda")}, inverseJoinColumns =
            {@JoinColumn(name = "idPeca")})
    private List<Peca> pecas;

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    @Temporal(TemporalType.DATE)
    private Calendar dtVenda;

    public Calendar getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Calendar dtVenda) {
        this.dtVenda = dtVenda;
    }


    @Temporal(TemporalType.DATE)
    private Calendar dtFinal;

    public Calendar getdtFinal() {
        return dtFinal;
    }

    public void setdtFinal(Calendar dtFinal) {
        this.dtFinal = dtFinal;
    }

    @Temporal(TemporalType.DATE)
    private Calendar dtPrevisao;

    public Calendar getDtPrevisao() {
        return dtPrevisao;
    }

    public void setDtPrevisao(Calendar dtPrevisao) {
        this.dtPrevisao = dtPrevisao;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;//dono

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    /*construtores */
    public Venda(List<Peca> pecas, Calendar dtVenda, Cliente cliente) {
        this.pecas = pecas;
        this.dtVenda = dtVenda;
        this.dtFinal = dtVenda;
        this.status = "PAGO";
        this.cliente = cliente;

    }
    public Venda(List<Peca> pecas, Calendar dtVenda, Calendar dtPrevisao, Cliente cliente){
        this.pecas = pecas;
        this.dtVenda = dtVenda;
        this.dtPrevisao = dtPrevisao;
        this.cliente = cliente;
        this.status = "FIADO";
        for(Peca p : pecas){
            cliente.fazerConta(p.getPreco());
        }
    }

    /*métodos específicos*/
    public void fazerPagamento(Calendar dataPagamento){
        setdtFinal(dataPagamento);
        setStatus("PAGO");
    }
    public void vendaCancelada(Calendar dataCancelamento){
        setdtFinal(dataCancelamento);
        setStatus("CANCELADO");
    }
    public void fazerVenda(){

    }
}

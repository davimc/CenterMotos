package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="moto")
public class Moto {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;//dono
    @OneToMany(mappedBy = "moto",targetEntity = Servico.class, fetch= FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Servico> servicos;//uma moto pode ter vários servicos
    private String marca;
    private String modelo;
    private String placa;

    public Moto(Cliente cliente, String marca, String modelo, String placa) {
        this.cliente = cliente;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    public Moto(String marca, String modelo, String placa, Cliente cliente){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cliente = cliente;
    }
}

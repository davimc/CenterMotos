package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Moto {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "servico")
    private List<Servico> servicos;
    private String marca;
    private String modelo;
    private String placa;


    public Moto(String marca,String modelo, String placa, Cliente cliente){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cliente = cliente;
    }
}

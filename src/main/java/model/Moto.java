package model;

import javax.persistence.*;

@Entity
public class Moto {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Cliente cliente;
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

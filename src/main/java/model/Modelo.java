package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Modelo {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Marca marca;
    private String nome;
}

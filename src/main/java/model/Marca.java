package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Marca {
    @Id @GeneratedValue
    private long id;
    @OneToMany
    private List<Modelo> modelos;
    String nome;
}

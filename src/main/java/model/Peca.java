package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Peca {
    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(mappedBy = "Servico")
    private List<Servico> servicos;
    private String nome;
    private double preco;
    private int quantidade;
    private String marca;
    @ElementCollection @Column(length = 20)
    private List<String> modelos;
}

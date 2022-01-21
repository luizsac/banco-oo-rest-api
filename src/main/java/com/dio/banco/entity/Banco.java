package com.dio.banco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor @Getter @Setter
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bancoId;
    @Column(nullable = false, unique = true)
    private Integer codigo;
    @Column(nullable = false)
    private String nome;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "banco")
    private List<Agencia> agencias;

}

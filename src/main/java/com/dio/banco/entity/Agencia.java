package com.dio.banco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agenciaId;
    @ManyToOne
    @JoinColumn(name = "banco_id")
    private Banco banco;
    @Column(nullable = false)
    private Integer numero;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agencia")
    private List<Conta> contas;

}

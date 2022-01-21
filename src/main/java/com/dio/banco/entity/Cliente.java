package com.dio.banco.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String telefone;
    @Column
    private String email;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "cliente")
    private List<Conta> contas;


}

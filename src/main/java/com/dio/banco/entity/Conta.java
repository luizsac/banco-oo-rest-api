package com.dio.banco.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance
@DiscriminatorColumn(name = "tipo_conta", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor @Getter @Setter
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long contaId;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    protected Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "agencia_id")
    protected Agencia agencia;
    @Column(nullable = false)
    protected Long numero;
    @Column(nullable = false)
    protected BigDecimal saldo;

    public Conta(Cliente cliente, Agencia agencia, Long numero) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = BigDecimal.ZERO;
    }

}
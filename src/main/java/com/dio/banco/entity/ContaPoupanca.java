package com.dio.banco.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONTA_POUPANCA")
@NoArgsConstructor
public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, Agencia agencia, Long numero) {
        super(cliente, agencia, numero);
    }

}

package com.dio.banco.entity;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONTA_CORRENTE")
@NoArgsConstructor
public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, Agencia agencia, Long numero) {
        super(cliente, agencia, numero);
    }

}

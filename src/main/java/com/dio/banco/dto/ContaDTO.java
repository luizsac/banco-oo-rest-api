package com.dio.banco.dto;

import com.dio.banco.entity.Agencia;
import com.dio.banco.entity.Cliente;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaDTO {

    private String tipoConta;
    private Long contaId;
    private Agencia agencia;
    private Cliente cliente;
    private Long numero;
    private BigDecimal saldo;

}

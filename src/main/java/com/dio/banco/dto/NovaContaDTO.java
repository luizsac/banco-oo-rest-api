package com.dio.banco.dto;

import com.dio.banco.type.TipoConta;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NovaContaDTO {

    private Long clienteId;
    private Long agenciaId;
    private TipoConta tipoConta;
    private Long numero;
    private BigDecimal saldo;

}

package com.dio.banco.dto;

import com.dio.banco.entity.Banco;
import lombok.Data;

@Data
public class NovaAgenciaDTO {

    private Banco banco;
    private Integer numero;

}

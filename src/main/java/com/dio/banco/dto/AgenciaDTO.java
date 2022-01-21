package com.dio.banco.dto;

import com.dio.banco.entity.Banco;
import lombok.Data;

@Data
public class AgenciaDTO {

    private Long agenciaId;
    private Banco banco;
    private Integer numero;

}

package com.dio.banco.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long clienteId;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

}

package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = " A agencia já se encontrada cadastrada no sistema")
public class AgenciaJaRegistradaException extends Exception {

    public AgenciaJaRegistradaException() {
        super();
    }

}

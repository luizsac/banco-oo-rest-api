package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = " A conta já se encontrada cadastrada no sistema")
public class ContaJaRegistradaException extends Exception {

    public ContaJaRegistradaException() {
        super();
    }

}

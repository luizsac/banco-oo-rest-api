package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A agência solicitada não foi encontrada")
public class AgenciaNaoEncontradaException extends Exception {

    public AgenciaNaoEncontradaException() {
        super();
    }

}

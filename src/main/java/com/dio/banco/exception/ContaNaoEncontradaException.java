package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A conta solicitada não foi encontrada")
public class ContaNaoEncontradaException extends Exception {

    public ContaNaoEncontradaException() {
        super();
    }

}

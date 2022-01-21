package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "O banco solicitado não foi encontrado")
public class BancoNaoEncontradoException extends Exception {

    public BancoNaoEncontradoException() {
        super();
    }

}

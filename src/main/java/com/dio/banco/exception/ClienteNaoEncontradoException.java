package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "O cliente solicitado não foi encontrado")
public class ClienteNaoEncontradoException extends Exception {

    public ClienteNaoEncontradoException() {
        super();
    }

}

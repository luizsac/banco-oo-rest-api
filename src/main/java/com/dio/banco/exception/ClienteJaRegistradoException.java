package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "O cliente já se encontra cadastrado no sistema")
public class ClienteJaRegistradoException extends Exception {

    public ClienteJaRegistradoException() {
        super();
    }

}

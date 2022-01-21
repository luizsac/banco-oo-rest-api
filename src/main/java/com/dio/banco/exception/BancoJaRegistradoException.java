package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "O banco já se encontrada cadastrado no sistema")
public class BancoJaRegistradoException extends Exception {

    public BancoJaRegistradoException() {
        super();
    }

}

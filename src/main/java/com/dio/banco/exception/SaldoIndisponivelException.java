package com.dio.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Não há saldo disponível para realizar a operação")
public class SaldoIndisponivelException extends Exception {

    public SaldoIndisponivelException() {
        super();
    }

}

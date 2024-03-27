package com.projeto.inter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContaCorrenteNotFoundException extends RuntimeException {
    public ContaCorrenteNotFoundException(String numeroConta) {
        super("Conta corrente não encontrada: " + numeroConta);
    }

    public ContaCorrenteNotFoundException(Long idConta) {
    }
}
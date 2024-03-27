package com.projeto.inter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FaturaNotFoundException extends RuntimeException {

    public FaturaNotFoundException(Long id) {
        super("Fatura não encontrada com ID: " + id);
    }

    public FaturaNotFoundException(String numeroConta) {
    }
}
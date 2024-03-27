package com.projeto.inter.services;

import com.projeto.inter.exception.ContaCorrenteNotFoundException;
import com.projeto.inter.model.ContaCorrente;
import com.projeto.inter.repository.RepositorioContaCorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaCorrenteService {

    private final RepositorioContaCorrente repositorioContaCorrente;

    @Autowired
    public ContaCorrenteService(RepositorioContaCorrente repositorioContaCorrente) {
        this.repositorioContaCorrente = repositorioContaCorrente;
    }

    public ContaCorrente encontrarContaPorNumero(Long numeroConta) {
        Optional<ContaCorrente> contaCorrenteOptional = repositorioContaCorrente.findById(numeroConta);
        return contaCorrenteOptional.orElseThrow(() -> new ContaCorrenteNotFoundException(numeroConta));
    }
}
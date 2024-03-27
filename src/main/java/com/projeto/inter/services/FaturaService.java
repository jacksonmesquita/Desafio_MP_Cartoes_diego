package com.projeto.inter.services;

import com.projeto.inter.exception.FaturaNotFoundException;
import com.projeto.inter.model.ContaCorrente;
import com.projeto.inter.model.FaturaModel;
import com.projeto.inter.repository.RepositorioFatura;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FaturaService {

    private final RepositorioFatura repositorioFatura;
    private final ContaCorrenteService contaCorrenteService;


    public FaturaService(RepositorioFatura repositorioFatura, ContaCorrenteService contaCorrenteService) {
        this.repositorioFatura = repositorioFatura;
        this.contaCorrenteService = contaCorrenteService;
    }

    public FaturaModel encontrarFaturaAbertaPorContaCorrente(Long numeroConta) {
        Optional<FaturaModel> faturaAberta = repositorioFatura.findByContaCorrenteNumeroContaAndFechadaFalse(numeroConta);

        if (faturaAberta.isPresent()) {
            return faturaAberta.get();
        } else {
            // Se não houver fatura aberta, crie uma nova fatura
            ContaCorrente contaCorrente = contaCorrenteService.encontrarContaPorNumero(numeroConta);

            FaturaModel novaFatura = new FaturaModel();
            novaFatura.setContaCorrente(contaCorrente);
            novaFatura.setFechada(false); // Definindo a fatura como aberta

            return repositorioFatura.save(novaFatura);
        }
    }
}



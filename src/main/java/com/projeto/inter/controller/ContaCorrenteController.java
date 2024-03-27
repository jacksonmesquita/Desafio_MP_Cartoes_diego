package com.projeto.inter.controller;

import com.projeto.inter.exception.ContaCorrenteNotFoundException;
import com.projeto.inter.model.ContaCorrente;
import com.projeto.inter.repository.RepositorioContaCorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaCorrenteController {

    private final RepositorioContaCorrente repositorioContaCorrente;

    @Autowired
    public ContaCorrenteController(RepositorioContaCorrente repositorioContaCorrente) {
        this.repositorioContaCorrente = repositorioContaCorrente;
    }
    @GetMapping("/{idConta}")
    public ContaCorrente obterContaPorNumero(@PathVariable Long idConta) {
        return repositorioContaCorrente.findById(idConta)
                .orElseThrow(() -> new ContaCorrenteNotFoundException(idConta));
    }

    @GetMapping
    public List<ContaCorrente> listarContas() {
        return repositorioContaCorrente.findAll();
    }

    @PostMapping
    public ContaCorrente criarConta(@RequestBody ContaCorrente contaCorrente) {
        return repositorioContaCorrente.save(contaCorrente);
    }

}

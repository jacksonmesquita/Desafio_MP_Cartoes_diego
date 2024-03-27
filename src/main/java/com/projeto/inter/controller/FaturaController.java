package com.projeto.inter.controller;

import com.projeto.inter.exception.FaturaNotFoundException;
import com.projeto.inter.model.FaturaModel;
import com.projeto.inter.model.TransacaoModel;
import com.projeto.inter.repository.RepositorioFatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faturas")
public class FaturaController {
    private final RepositorioFatura repositorioFatura;

    @Autowired
    public FaturaController(RepositorioFatura repositorioFatura) {
        this.repositorioFatura = repositorioFatura;
    }

    @PostMapping("/{id}/fechar")
    public void fecharFatura(@PathVariable Long id, @RequestParam String contaCorrente) {

        FaturaModel fatura = repositorioFatura.findById(id).orElseThrow(() -> new FaturaNotFoundException(id));


        fatura.setFechada(true);

        repositorioFatura.save(fatura);
    }

    @GetMapping("/{id}/transacoes")
    public List<TransacaoModel> listarTransacoesFatura(@PathVariable Long id, @RequestParam String contaCorrente) {

        FaturaModel fatura = repositorioFatura.findById(id).orElseThrow(() -> new FaturaNotFoundException(id));


        return fatura.getTransacoes();
    }
}


package com.projeto.inter.controller;

import com.projeto.inter.model.FaturaModel;
import com.projeto.inter.model.TransacaoModel;
import com.projeto.inter.model.TransacaoRequest;
import com.projeto.inter.repository.RepositorioTransacao;
import com.projeto.inter.services.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    private final RepositorioTransacao repositorioTransacao;
    private final FaturaService faturaService;

    @Autowired
    public TransacaoController(RepositorioTransacao repositorioTransacao, FaturaService faturaService) {
        this.repositorioTransacao = repositorioTransacao;
        this.faturaService = faturaService;
    }

    @PostMapping
    public Long criarTransacao(@RequestBody TransacaoRequest transacaoRequest) {
        TransacaoModel transacao = new TransacaoModel();
        transacao.setDataTransacao(transacaoRequest.getDataTransacao());
        transacao.setNomeEstabelecimento(transacaoRequest.getNomeEstabelecimento());
        transacao.setValor(transacaoRequest.getValor());
        transacao.setValorParcela(transacaoRequest.getValorParcela());
        transacao.setQuantidadeParcelas(transacaoRequest.getQuantidadeParcelas());
        transacao.setNumeroParcelaAtual(1); // Definido como 1 para a primeira parcela


        Long numeroContaCorrente = null;
        if (transacaoRequest.getContaCorrente() != null && !transacaoRequest.getContaCorrente().isEmpty()) {
            numeroContaCorrente = Long.valueOf(transacaoRequest.getContaCorrente());
        }

        FaturaModel faturaAberta = faturaService.encontrarFaturaAbertaPorContaCorrente(numeroContaCorrente);
        transacao.setFatura(faturaAberta);

        TransacaoModel transacaoSalva = repositorioTransacao.save(transacao);
        return transacaoSalva.getId();
    }


    @GetMapping
    public List<TransacaoModel> listarTransacoes(@RequestParam LocalDate dataFechamento, @RequestParam Long numeroConta) {

        return repositorioTransacao.findByFatura_DataFechamentoAndFatura_ContaCorrente_NumeroConta(dataFechamento, numeroConta);
    }
}


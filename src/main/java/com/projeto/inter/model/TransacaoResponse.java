package com.projeto.inter.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
public class TransacaoResponse {

    private LocalDate dataTransacao;
    private String nomeEstabelecimento;
    private double valor;
    private double valorParcela;
    private int quantidadeParcelas;
    private int numeroParcelaAtual;

    public TransacaoResponse(LocalDate dataTransacao,
                             String nomeEstabelecimento,
                             double valor, double valorParcela, int quantidadeParcelas, int numeroParcelaAtual) {
        this.dataTransacao = dataTransacao;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.valor = valor;
        this.valorParcela = valorParcela;
        this.quantidadeParcelas = quantidadeParcelas;
        this.numeroParcelaAtual = numeroParcelaAtual;
    }
}

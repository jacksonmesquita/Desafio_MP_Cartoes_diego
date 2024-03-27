package com.projeto.inter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
public class TransacaoRequest {
    private LocalDate dataTransacao;
    private String nomeEstabelecimento;
    private double valor;
    private double valorParcela;
    private int quantidadeParcelas;
    private String contaCorrente;


    public TransacaoRequest(LocalDate dataTransacao,
                            String nomeEstabelecimento, double valor, double valorParcela, int quantidadeParcelas, String contaCorrente) {
        this.dataTransacao = dataTransacao;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.valor = valor;
        this.valorParcela = valorParcela;
        this.quantidadeParcelas = quantidadeParcelas;
        this.contaCorrente = contaCorrente;
    }
}

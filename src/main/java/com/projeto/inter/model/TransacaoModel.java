package com.projeto.inter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class TransacaoModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataTransacao;

    @Column
    private String nomeEstabelecimento;

    @Column
    private double valor;

    @Column
    private double valorParcela;

    @Column
    private int quantidadeParcelas;

    @Column
    private int numeroParcelaAtual;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_fatura")
    private FaturaModel fatura;


    public TransacaoModel(LocalDate dataTransacao,
                          String nomeEstabelecimento,
                          double valor, double valorParcela,
                          int quantidadeParcelas,
                          int numeroParcelaAtual)
    {
        this.dataTransacao = dataTransacao;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.valor = valor;
        this.valorParcela = valorParcela;
        this.quantidadeParcelas = quantidadeParcelas;
        this.numeroParcelaAtual = numeroParcelaAtual;
    }


    @Override
    public String toString() {
        return "Transacao{" +
                "dataTransacao=" + dataTransacao +
                ", nomeEstabelecimento='" + nomeEstabelecimento + '\'' +
                ", valor=" + valor +
                ", valorParcela=" + valorParcela +
                ", quantidadeParcelas=" + quantidadeParcelas +
                ", numeroParcelaAtual=" + numeroParcelaAtual +
                '}';

    }
}


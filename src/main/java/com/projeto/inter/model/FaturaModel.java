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
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class FaturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFechamento;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;

    @JsonBackReference
    @OneToMany(mappedBy = "fatura")
    private List<TransacaoModel> transacoes;

    @Column
    private boolean fechada;

    @ManyToOne
    @JoinColumn(name = "id_conta_corrente")
    private ContaCorrente contaCorrente;

    public FaturaModel(Long id, LocalDate dataFechamento, LocalDate dataVencimento) {
        this.id = id;
        this.dataFechamento = dataFechamento;
        this.dataVencimento = dataVencimento;
        this.transacoes = new ArrayList<>();
        this.fechada = false;
    }
}

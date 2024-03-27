package com.projeto.inter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroConta;

    @OneToMany(mappedBy = "contaCorrente")
    private List<FaturaModel> faturas;

    @Column
    private String cliente;
    public ContaCorrente(Long numeroConta, String cliente, List<FaturaModel> faturas) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.faturas = faturas;
    }
}

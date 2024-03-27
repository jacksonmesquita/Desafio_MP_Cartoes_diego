package com.projeto.inter.repository;

import com.projeto.inter.model.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepositorioTransacao extends JpaRepository<TransacaoModel, Long> {
    List<TransacaoModel> findByFatura_DataFechamentoAndFatura_ContaCorrente_NumeroConta(LocalDate dataFechamento, Long numeroConta);
}
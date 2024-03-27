package com.projeto.inter.repository;

import com.projeto.inter.model.FaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioFatura extends JpaRepository<FaturaModel, Long> {
    Optional<FaturaModel> findByContaCorrenteNumeroContaAndFechadaFalse(Long idConta);
}
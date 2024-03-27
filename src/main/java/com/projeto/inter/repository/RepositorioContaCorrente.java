package com.projeto.inter.repository;

import com.projeto.inter.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioContaCorrente extends JpaRepository<ContaCorrente, Long> {
    Optional<ContaCorrente> findById(Long idConta);
}

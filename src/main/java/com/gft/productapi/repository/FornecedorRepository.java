package com.gft.productapi.repository;

import java.util.Optional;

import com.gft.productapi.entity.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    Optional<Fornecedor> findByNomeIgnoreCaseContaining(String nome);
}

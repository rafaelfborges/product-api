package com.gft.productapi.repository;

import com.gft.productapi.entity.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findAllByOrderByNomeAsc();
    List<Fornecedor> findAllByOrderByNomeDesc();
    Optional<Fornecedor> findByNomeIgnoreCaseContaining(String nome);
}

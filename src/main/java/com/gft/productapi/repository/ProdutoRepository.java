package com.gft.productapi.repository;

import java.util.Optional;

import com.gft.productapi.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNomeIgnoreCaseContaining(String nome);
}

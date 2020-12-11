package com.gft.productapi.repository;

import com.gft.productapi.entity.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByOrderByNomeAsc();
    List<Produto> findAllByOrderByNomeDesc();
    Optional<Produto> findByNomeIgnoreCaseContaining(String nome);
}

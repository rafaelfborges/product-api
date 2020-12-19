package com.gft.productapi.repository;

import java.util.Optional;

import com.gft.productapi.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNomeIgnoreCaseContaining(String nome);
}

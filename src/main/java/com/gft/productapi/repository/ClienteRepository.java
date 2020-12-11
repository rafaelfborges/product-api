package com.gft.productapi.repository;

import java.util.List;
import java.util.Optional;

import com.gft.productapi.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByOrderByNomeAsc();
    List<Cliente> findAllByOrderByNomeDesc();
    Optional<Cliente> findByNomeIgnoreCaseContaining(String nome);
}

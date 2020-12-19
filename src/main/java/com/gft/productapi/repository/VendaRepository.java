package com.gft.productapi.repository;

import java.util.Optional;

import com.gft.productapi.entity.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    Optional<Venda> findVendaByClienteNomeContainingIgnoreCase(String nome);
}

package com.gft.productapi.repository;

import com.gft.productapi.entity.Venda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    
}
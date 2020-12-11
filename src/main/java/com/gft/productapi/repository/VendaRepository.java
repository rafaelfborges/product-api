package com.gft.productapi.repository;

import com.gft.productapi.entity.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findAllByOrderByEmpresaNomeAsc();
    List<Venda> findAllByOrderByEmpresaNomeDesc();
    Optional<Venda> findVendaByClienteNomeContainingIgnoreCase(String nome);
}

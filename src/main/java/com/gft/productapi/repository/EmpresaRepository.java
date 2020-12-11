package com.gft.productapi.repository;

import com.gft.productapi.entity.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findAllByOrderByNomeAsc();
    List<Empresa> findAllByOrderByNomeDesc();
    Optional<Empresa> findByNomeIgnoreCaseContaining(String nome);
}

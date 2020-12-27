package com.gft.productapi.repository;

import java.util.Optional;

import com.gft.productapi.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByNameIgnoreCaseContaining(String name);
}

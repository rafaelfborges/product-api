package com.gft.productapi.repository;

import java.util.Optional;

import com.gft.productapi.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameIgnoreCaseContaining(String name);
}

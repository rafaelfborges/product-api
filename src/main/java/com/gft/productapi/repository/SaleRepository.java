package com.gft.productapi.repository;

import com.gft.productapi.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Optional<Sale> findSaleByClientNameContainingIgnoreCase(String name);
}

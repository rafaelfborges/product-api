package com.gft.productapi.repository;

import java.util.Optional;

import com.gft.productapi.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    Optional<Sale> findSaleByClientNameContainingIgnoreCase(String name);
}

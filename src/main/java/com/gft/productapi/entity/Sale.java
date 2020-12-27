package com.gft.productapi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sale {
    
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Supplier supplier;

    @NotNull
    @ManyToOne
    private Client client;

    @JsonIgnoreProperties("supplier")
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

    @Column(name = "total_sale")
    private BigDecimal totalSale;

    @NotNull
    @Column(name = "date_sale")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateSale;
}

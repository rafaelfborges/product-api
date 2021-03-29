package com.gft.productapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

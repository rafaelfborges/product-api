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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda {
    
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Fornecedor fornecedor;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    @JsonIgnoreProperties("fornecedor")
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Produto> produtos = new HashSet<>();

    @Column(name = "total_compra")
    private BigDecimal totalCompra;

    @NotNull
    @Column(name = "data_compra")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

package com.gft.productapi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private Fornecedor fornecedor;

    @ManyToOne
    @ToString.Exclude
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos;

    @Column(name = "total_compra")
    private BigDecimal totalCompra;

    @Column(name = "data_compra")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataCompra;
}

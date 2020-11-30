package com.gft.productapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Fornecedor fornecedor;

    private Cliente cliente;

    private List<Produto> produtos;
}

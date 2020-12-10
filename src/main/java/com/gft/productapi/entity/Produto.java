package com.gft.productapi.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
    
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String codigoProduto;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Boolean promocao;

    private BigDecimal valorPromo;

    @NotBlank
    private String categoria;

    @NotBlank
    private String imagem;

    @NotNull
    private Long quantidade;

    @NotNull
    @ManyToOne
    private Empresa empresa;

    public void diminuirQuantidade() {
        if(this.quantidade > 0) 
            this.quantidade--;
    }
}

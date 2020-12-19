package com.gft.productapi.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
    
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String codigoProduto;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private Boolean promocao;

    @PositiveOrZero
    private BigDecimal valorPromo;

    @NotBlank
    private String categoria;

    @NotBlank
    private String imagem;

    @NotNull
    @PositiveOrZero
    private Long quantidade;

    @NotNull
    @ManyToOne
    private Fornecedor fornecedor;

    public void diminuirQuantidade() {
        if(this.quantidade > 0) 
            this.quantidade--;
    }
}

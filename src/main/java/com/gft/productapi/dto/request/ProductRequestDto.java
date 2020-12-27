package com.gft.productapi.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.gft.productapi.dto.SupplierDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductRequestDto {

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
    private SupplierDto fornecedor;
}

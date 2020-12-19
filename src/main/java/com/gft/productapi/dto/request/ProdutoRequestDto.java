package com.gft.productapi.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gft.productapi.dto.FornecedorDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ProdutoRequestDto {

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
    private FornecedorDto fornecedor;
}

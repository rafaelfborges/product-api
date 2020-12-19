package com.gft.productapi.dto.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gft.productapi.entity.Fornecedor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ProdutoRequestDto {
    private String nome;
    private String codigoProduto;
    private BigDecimal valor;
    private Boolean promocao;
    private BigDecimal valorPromo;
    private String categoria;
    private String imagem;
    private Long quantidade;
    private Fornecedor fornecedor;
}

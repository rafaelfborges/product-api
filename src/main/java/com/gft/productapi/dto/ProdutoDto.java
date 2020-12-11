package com.gft.productapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ProdutoDto {
    private Long id;
    private String nome;
    private String codigoProduto;
    private BigDecimal valor;
    private Boolean promocao;
    private BigDecimal valorPromo;
    private String categoria;
    private String imagem;
    private Long quantidade;
    private FornecedorDto fornecedor;
}

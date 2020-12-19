package com.gft.productapi.dto.response;

import java.math.BigDecimal;

import com.gft.productapi.dto.FornecedorDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoResponseDto {
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

package com.gft.productapi.dto.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gft.productapi.entity.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FornecedorResponseDto {
    private Long id;
    private String nome;
    private String cnpj;

    @JsonIgnoreProperties("fornecedor")
    private Set<Produto> produtos;
}

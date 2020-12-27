package com.gft.productapi.dto.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gft.productapi.dto.id.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SupplierResponseDto {
    private Long id;
    private String nome;
    private String cnpj;

    @JsonIgnoreProperties("supplier")
    private Set<ProductDto> produtos;
}

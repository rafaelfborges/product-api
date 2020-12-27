package com.gft.productapi.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.productapi.dto.ClientDto;
import com.gft.productapi.dto.SupplierDto;
import com.gft.productapi.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaleResponseDto {
    private Long id;
    private SupplierDto fornecedor;
    private ClientDto cliente;
    private Set<ProductDto> produtos;
    private BigDecimal totalCompra;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

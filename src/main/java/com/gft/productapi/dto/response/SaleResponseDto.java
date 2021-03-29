package com.gft.productapi.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.productapi.dto.id.ClientDto;
import com.gft.productapi.dto.id.ProductDto;
import com.gft.productapi.dto.id.SupplierDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class SaleResponseDto {
    private Long id;
    private SupplierDto fornecedor;
    private ClientDto cliente;
    private Set<ProductDto> produtos;
    private BigDecimal totalCompra;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

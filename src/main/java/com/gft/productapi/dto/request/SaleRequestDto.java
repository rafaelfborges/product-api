package com.gft.productapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.productapi.dto.id.ClientDto;
import com.gft.productapi.dto.id.ProductDto;
import com.gft.productapi.dto.id.SupplierDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class SaleRequestDto {

    @NotNull
    private SupplierDto fornecedor;

    @NotNull
    private ClientDto cliente;

    @NotNull
    private Set<ProductDto> produtos;

    private BigDecimal totalCompra;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

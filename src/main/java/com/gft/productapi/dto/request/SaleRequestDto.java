package com.gft.productapi.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.productapi.dto.ClientDto;
import com.gft.productapi.dto.SupplierDto;
import com.gft.productapi.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaleRequestDto {

    @NotNull
    private SupplierDto supplier;

    @NotNull
    private ClientDto client;

    @NotNull
    private Set<ProductDto> products;

    private BigDecimal totalSale;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateSale;
}

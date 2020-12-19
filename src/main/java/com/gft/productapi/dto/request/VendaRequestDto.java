package com.gft.productapi.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.productapi.dto.ClienteDto;
import com.gft.productapi.dto.FornecedorDto;
import com.gft.productapi.dto.ProdutoDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VendaRequestDto {

    @NotNull
    private FornecedorDto fornecedor;

    @NotNull
    private ClienteDto cliente;

    @NotNull
    private Set<ProdutoDto> produtos;

    private BigDecimal totalCompra;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

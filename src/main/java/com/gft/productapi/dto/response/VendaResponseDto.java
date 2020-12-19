package com.gft.productapi.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.productapi.dto.ClienteDto;
import com.gft.productapi.dto.FornecedorDto;
import com.gft.productapi.dto.ProdutoDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VendaResponseDto {
    private Long id;
    private FornecedorDto fornecedor;
    private ClienteDto cliente;
    private Set<ProdutoDto> produtos;
    private BigDecimal totalCompra;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

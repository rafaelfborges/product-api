package com.gft.productapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gft.productapi.entity.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VendaDto {
    private Long id;
    private EmpresaDto empresa;
    private ClienteDto cliente;

    @JsonIgnoreProperties({"empresa", "quantidade"})
    private Set<Produto> produtos;

    private BigDecimal totalCompra;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

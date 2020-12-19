package com.gft.productapi.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gft.productapi.entity.Cliente;
import com.gft.productapi.entity.Fornecedor;
import com.gft.productapi.entity.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class VendaResponseDto {
    private Long id;
    private Fornecedor fornecedor;
    private Cliente cliente;
    
    @JsonIgnoreProperties({"fornecedor", "quantidade"})
    private Set<Produto> produtos;
    private BigDecimal totalCompra;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;
}

package com.gft.productapi.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteDto {
    private Long id;
    private String nome;
    private String email;
    private String documento;
    private LocalDate dataCadastro;
}

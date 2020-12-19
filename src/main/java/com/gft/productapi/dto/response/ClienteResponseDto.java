package com.gft.productapi.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ClienteResponseDto {
    private Long id;
    private String nome;
    private String email;
    private String documento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
}
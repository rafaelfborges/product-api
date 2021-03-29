package com.gft.productapi.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientResponseDto {
    private Long id;
    private String nome;
    private String email;
    private String documento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
}

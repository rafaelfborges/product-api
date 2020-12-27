package com.gft.productapi.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ClientResponseDto {
    private Long id;
    private String name;
    private String email;
    private String document;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate registerDate;
}
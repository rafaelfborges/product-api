package com.gft.productapi.dto.request;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SupplierRequestDto {

    @NotBlank
    private String nome;

    @CNPJ
    @NotBlank
    private String cnpj;
}

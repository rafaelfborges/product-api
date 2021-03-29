package com.gft.productapi.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SupplierRequestDto {

    @NotBlank
    private String nome;

    @CNPJ
    @NotBlank
    private String cnpj;
}

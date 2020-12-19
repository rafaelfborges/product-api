package com.gft.productapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ClienteRequestDto {
    private String nome;
    private String email;
    private String senha;
    private String documento;
}

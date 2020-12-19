package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.FornecedorRequestDto;
import com.gft.productapi.dto.response.FornecedorResponseDto;
import com.gft.productapi.entity.Fornecedor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {
    
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "cnpj", target = "cnpj")
    Fornecedor mapRequest(FornecedorRequestDto fornecedor);
    List<Fornecedor> mapRequest(List<FornecedorRequestDto> fornecedores);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "cnpj", target = "cnpj")
    @Mapping(source = "produtos", target = "produtos")
    FornecedorResponseDto mapResponse(Fornecedor fornecedor);
    List<FornecedorResponseDto> mapResponse(List<Fornecedor> fornecedores);
}

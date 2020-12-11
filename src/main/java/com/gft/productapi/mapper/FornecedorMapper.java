package com.gft.productapi.mapper;

import com.gft.productapi.dto.FornecedorDto;
import com.gft.productapi.entity.Fornecedor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    FornecedorDto map(Fornecedor fornecedor);
}

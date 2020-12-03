package com.gft.productapi.mapper;

import com.gft.productapi.dto.EmpresaDto;
import com.gft.productapi.entity.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nome", target = "nome")
    })
    EmpresaDto map(Empresa empresa);
}

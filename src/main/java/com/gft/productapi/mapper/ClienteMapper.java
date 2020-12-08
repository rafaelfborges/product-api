package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.ClienteDto;
import com.gft.productapi.entity.Cliente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "documento", target = "documento")
    @Mapping(source = "dataCadastro", target = "dataCadastro", dateFormat = "dd/MM/yyyy")
    ClienteDto map(Cliente cliente);

    List<ClienteDto> map(List<Cliente> cliente);
}

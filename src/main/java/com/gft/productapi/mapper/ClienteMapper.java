package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.ClienteRequestDto;
import com.gft.productapi.dto.response.ClienteResponseDto;
import com.gft.productapi.entity.Cliente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "senha", target = "senha")
    @Mapping(source = "documento", target = "documento")
    Cliente mapRequest(ClienteRequestDto clienteDto);
    List<Cliente> mapRequest(List<ClienteRequestDto> clientes);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "documento", target = "documento")
    @Mapping(source = "dataCadastro", target = "dataCadastro", dateFormat = "dd/MM/yyyy")
    ClienteResponseDto mapResponse(Cliente cliente);   
    List<ClienteResponseDto> mapResponse(List<Cliente> clientes);
}

package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.ClientRequestDto;
import com.gft.productapi.dto.response.ClientResponseDto;
import com.gft.productapi.entity.Client;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "document", target = "document")
    Client mapRequest(ClientRequestDto clienteDto);
    List<Client> mapRequest(List<ClientRequestDto> clients);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "document", target = "document")
    @Mapping(source = "registerDate", target = "registerDate", dateFormat = "dd/MM/yyyy")
    ClientResponseDto mapResponse(Client client);
    List<ClientResponseDto> mapResponse(List<Client> clients);
}

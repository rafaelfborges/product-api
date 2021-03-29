package com.gft.productapi.mapper;

import com.gft.productapi.dto.request.ClientRequestDto;
import com.gft.productapi.dto.response.ClientResponseDto;
import com.gft.productapi.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(source = "nome", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "senha", target = "password")
    @Mapping(source = "documento", target = "document")
    Client mapRequest(ClientRequestDto clienteDto);
    List<Client> mapRequest(List<ClientRequestDto> clients);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "document", target = "documento")
    @Mapping(source = "registerDate", target = "dataCadastro", dateFormat = "dd/MM/yyyy")
    ClientResponseDto mapResponse(Client client);
    List<ClientResponseDto> mapResponse(List<Client> clients);
}

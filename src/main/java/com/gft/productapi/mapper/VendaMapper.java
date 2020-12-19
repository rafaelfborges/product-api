package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.VendaRequestDto;
import com.gft.productapi.dto.response.VendaResponseDto;
import com.gft.productapi.entity.Venda;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VendaMapper {
    
    @Mapping(source = "fornecedor", target = "fornecedor")
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "produtos", target = "produtos")
    @Mapping(source = "totalCompra", target = "totalCompra")
    @Mapping(source = "dataCompra", target = "dataCompra", dateFormat = "dd/MM/yyyy")
    Venda mapRequest(VendaRequestDto venda);
    List<Venda> mapRequest(List<VendaRequestDto> vendas);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fornecedor", target = "fornecedor")
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "produtos", target = "produtos")
    @Mapping(source = "totalCompra", target = "totalCompra")
    @Mapping(source = "dataCompra", target = "dataCompra", dateFormat = "dd/MM/yyyy")
    VendaResponseDto mapResponse(Venda venda);
    List<VendaResponseDto> mapResponse(List<Venda> vendas);
}

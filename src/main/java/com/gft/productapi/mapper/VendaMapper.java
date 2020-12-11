package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.VendaDto;
import com.gft.productapi.entity.Venda;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VendaMapper {
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "fornecedor", target = "fornecedor")
    @Mapping(source = "cliente", target = "cliente")
    @Mapping(source = "produtos", target = "produtos")
    @Mapping(source = "totalCompra", target = "totalCompra")
    @Mapping(source = "dataCompra", target = "dataCompra", dateFormat = "dd/MM/yyyy")
    VendaDto map(Venda venda);

    List<VendaDto> map(List<Venda> vendas);
}

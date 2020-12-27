package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.SupplierRequestDto;
import com.gft.productapi.dto.response.SupplierResponseDto;

import com.gft.productapi.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    
    @Mapping(source = "nome", target = "name")
    @Mapping(source = "cnpj", target = "cnpj")
    Supplier mapRequest(SupplierRequestDto supplier);
    List<Supplier> mapRequest(List<SupplierRequestDto> suppliers);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "nome")
    @Mapping(source = "cnpj", target = "cnpj")
    @Mapping(source = "products", target = "produtos")
    SupplierResponseDto mapResponse(Supplier supplier);
    List<SupplierResponseDto> mapResponse(List<Supplier> suppliers);
}

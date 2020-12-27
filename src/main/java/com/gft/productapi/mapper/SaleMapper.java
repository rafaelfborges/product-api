package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.SaleRequestDto;
import com.gft.productapi.dto.response.SaleResponseDto;

import com.gft.productapi.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    
    @Mapping(source = "supplier", target = "supplier")
    @Mapping(source = "client", target = "client")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "totalSale", target = "totalSale")
    @Mapping(source = "dateSale", target = "dateSale", dateFormat = "dd/MM/yyyy")
    Sale mapRequest(SaleRequestDto sale);
    List<Sale> mapRequest(List<SaleRequestDto> sales);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "supplier", target = "supplier")
    @Mapping(source = "client", target = "client")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "totalSale", target = "totalSale")
    @Mapping(source = "dateSale", target = "dateSale", dateFormat = "dd/MM/yyyy")
    SaleResponseDto mapResponse(Sale sale);
    List<SaleResponseDto> mapResponse(List<Sale> sales);
}

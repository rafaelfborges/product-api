package com.gft.productapi.mapper;

import com.gft.productapi.dto.request.SaleRequestDto;
import com.gft.productapi.dto.response.SaleResponseDto;
import com.gft.productapi.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(source = "fornecedor", target = "supplier")
    @Mapping(source = "cliente", target = "client")
    @Mapping(source = "produtos", target = "products")
    @Mapping(source = "totalCompra", target = "totalSale")
    @Mapping(source = "dataCompra", target = "dateSale", dateFormat = "dd/MM/yyyy")
    Sale mapRequest(SaleRequestDto sale);
    List<Sale> mapRequest(List<SaleRequestDto> sales);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "supplier", target = "fornecedor")
    @Mapping(source = "client", target = "cliente")
    @Mapping(source = "products", target = "produtos")
    @Mapping(source = "totalSale", target = "totalCompra")
    @Mapping(source = "dateSale", target = "dataCompra", dateFormat = "dd/MM/yyyy")
    SaleResponseDto mapResponse(Sale sale);
    List<SaleResponseDto> mapResponse(List<Sale> sales);
}

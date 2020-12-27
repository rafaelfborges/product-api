package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;
import com.gft.productapi.entity.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    @Mapping(source = "name", target = "name")
    @Mapping(source = "productCode", target = "productCode")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "promotion", target = "promotion")
    @Mapping(source = "promotionValue", target = "promotionValue")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "supplier", target = "supplier")
    Product mapRequest(ProdutoRequestDto product);
    List<Product> mapRequest(List<ProdutoRequestDto> products);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "productCode", target = "productCode")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "promotion", target = "promotion")
    @Mapping(source = "promotionValue", target = "promotionValue")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "supplier", target = "supplier")
    ProductResponseDto mapResponse(Product product);
    List<ProductResponseDto> mapResponse(List<Product> products);
}

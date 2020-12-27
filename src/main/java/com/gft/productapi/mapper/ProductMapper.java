package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.ProductRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;
import com.gft.productapi.entity.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    @Mapping(source = "nome", target = "name")
    @Mapping(source = "codigoProduto", target = "productCode")
    @Mapping(source = "valor", target = "value")
    @Mapping(source = "promocao", target = "promotion")
    @Mapping(source = "valorPromo", target = "promotionValue")
    @Mapping(source = "categoria", target = "category")
    @Mapping(source = "imagem", target = "image")
    @Mapping(source = "quantidade", target = "quantity")
    @Mapping(source = "fornecedor", target = "supplier")
    Product mapRequest(ProductRequestDto product);
    List<Product> mapRequest(List<ProductRequestDto> products);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "nome")
    @Mapping(source = "productCode", target = "codigoProduto")
    @Mapping(source = "value", target = "valor")
    @Mapping(source = "promotion", target = "promocao")
    @Mapping(source = "promotionValue", target = "valorPromo")
    @Mapping(source = "category", target = "categoria")
    @Mapping(source = "image", target = "imagem")
    @Mapping(source = "quantity", target = "quantidade")
    @Mapping(source = "supplier", target = "fornecedor")
    ProductResponseDto mapResponse(Product product);
    List<ProductResponseDto> mapResponse(List<Product> products);
}

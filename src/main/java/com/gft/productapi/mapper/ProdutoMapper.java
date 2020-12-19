package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProdutoResponseDto;
import com.gft.productapi.entity.Produto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "codigoProduto", target = "codigoProduto")
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "promocao", target = "promocao")
    @Mapping(source = "valorPromo", target = "valorPromo")
    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "imagem", target = "imagem")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "fornecedor", target = "fornecedor")
    Produto mapRequest(ProdutoRequestDto produto);
    List<Produto> mapRequest(List<ProdutoRequestDto> produtos);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "codigoProduto", target = "codigoProduto")
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "promocao", target = "promocao")
    @Mapping(source = "valorPromo", target = "valorPromo")
    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "imagem", target = "imagem")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "fornecedor", target = "fornecedor")
    ProdutoResponseDto mapResponse(Produto produto);
    List<ProdutoResponseDto> mapResponse(List<Produto> produtos);
}

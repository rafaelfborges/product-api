package com.gft.productapi.mapper;

import java.util.List;

import com.gft.productapi.dto.ProdutoDto;
import com.gft.productapi.entity.Produto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "codigoProduto", target = "codigoProduto")
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "promocao", target = "promocao")
    @Mapping(source = "valorPromo", target = "valorPromo")
    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "imagem", target = "imagem")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "empresa", target = "empresa")
    ProdutoDto map(Produto produto);

    List<ProdutoDto> map(List<Produto> produtos);
}

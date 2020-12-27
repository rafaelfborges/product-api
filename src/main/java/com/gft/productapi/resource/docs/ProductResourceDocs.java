package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Produtos")
public interface ProductResourceDocs {
    
    @ApiOperation("Listar todas os produtos")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    Page<ProductResponseDto> findAll(Pageable pageable);

    @ApiOperation("Buscar um produto pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ProductResponseDto findById(@ApiParam(value = "Id de um produto", example = "1") Long id);

    @ApiOperation("Buscar um produto pelo nome")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ProductResponseDto findByNome(@ApiParam(value = "Nome de um produto", example = "Notebook") String name);
    
    @ApiOperation("Adiciona um novo produto")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ProductResponseDto create(ProdutoRequestDto product);
    
    @ApiOperation("Atualiza um produto")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ProductResponseDto update(@ApiParam(value = "Id de um produto", example = "1") Long id, ProdutoRequestDto product);

    @ApiOperation("Remove um produto")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    void remove(Long id);
}

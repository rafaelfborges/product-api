package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProdutoResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Produtos")
public interface ProdutoResourceDocs {
    
    @ApiOperation("Listar todas os produtos")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<Page<ProdutoResponseDto>> findAll(Pageable pageable);

    @ApiOperation("Buscar um produto pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ProdutoResponseDto> findById(@ApiParam(value = "Id de um produto", example = "1") Long id);

    @ApiOperation("Buscar um produto pelo nome")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ProdutoResponseDto> findByNome(@ApiParam(value = "Nome de um produto", example = "Notebook") 
                                                  String nome);
    
    @ApiOperation("Adiciona um novo produto")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ProdutoResponseDto> create(ProdutoRequestDto produto);
    
    @ApiOperation("Atualiza um produto")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ProdutoResponseDto> update(@ApiParam(value = "Id de um produto", example = "1") 
                                                     Long id, 
                                                     ProdutoRequestDto produto);

    @ApiOperation("Remove um produto")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    void remove(Long id);
}

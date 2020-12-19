package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.FornecedorRequestDto;
import com.gft.productapi.dto.response.FornecedorResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Fornecedores")
public interface FornecedorResouceDocs {
    
    @ApiOperation("Listar todas os fornecedores")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<Page<FornecedorResponseDto>> findAll(Pageable pageable);

    @ApiOperation("Buscar um fornecedor pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<FornecedorResponseDto> findById(@ApiParam(value = "Id de um fornecedor", example = "1") Long id);

    @ApiOperation("Buscar um fornecedor pelo nome")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<FornecedorResponseDto> findByNome(@ApiParam(value = "Nome de um fornecedor", example = "Amazon") 
                                                     String nome);

    @ApiOperation("Adiciona um novo fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<FornecedorResponseDto> create(FornecedorRequestDto fornecedor);

    @ApiOperation("Atualiza um fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<FornecedorResponseDto> update(@ApiParam(value = "Id de um fornecedor", example = "1") 
                                                 Long id,
                                                 FornecedorRequestDto fornecedor);

    @ApiOperation("Remove um fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    void remove(@PathVariable Long id);
}

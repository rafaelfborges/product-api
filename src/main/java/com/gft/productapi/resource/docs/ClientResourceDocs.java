package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.ClientRequestDto;
import com.gft.productapi.dto.response.ClientResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Clientes")
public interface ClientResourceDocs {
    
    @ApiOperation("Listar todas os clientes")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    Page<ClientResponseDto> findAll(Pageable pageable);

    @ApiOperation("Buscar um cliente pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ClientResponseDto findById(@ApiParam(value = "Id de um cliente", example = "1") Long id);

    @ApiOperation("Buscar um cliente pelo nome")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ClientResponseDto findByNome(@ApiParam(value = "Nome de um cliente", example = "Rafael") String name);

    @ApiOperation("Adiciona um novo cliente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ClientResponseDto create(ClientRequestDto client);

    @ApiOperation("Atualiza um cliente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ClientResponseDto update(@ApiParam(value = "Id de um cliente", example = "1") Long id, ClientRequestDto client);

    @ApiOperation("Remove um cliente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    void remove(Long id);
}

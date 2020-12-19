package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.ClienteRequestDto;
import com.gft.productapi.dto.response.ClienteResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Clientes")
public interface ClienteResourceDocs {
    
    @ApiOperation("Listar todas os clientes")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<Page<ClienteResponseDto>> findAll(Pageable pageable);

    @ApiOperation("Buscar um cliente pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ClienteResponseDto> findById(@ApiParam(value = "Id de um cliente", example = "1") Long id);

    @ApiOperation("Buscar um cliente pelo nome")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ClienteResponseDto> findByNome(@ApiParam(value = "Nome de um cliente", example = "Rafael") 
                                                  String nome);

    @ApiOperation("Adiciona um novo cliente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ClienteResponseDto> create(ClienteRequestDto cliente);

    @ApiOperation("Atualiza um cliente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<ClienteResponseDto> update(@ApiParam(value = "Id de um cliente", example = "1") 
                                              Long id, 
                                              ClienteRequestDto cliente);

    @ApiOperation("Remove um cliente")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    void remove(Long id);
}

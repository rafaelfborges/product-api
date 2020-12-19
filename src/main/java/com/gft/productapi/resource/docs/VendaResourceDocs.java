package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.VendaRequestDto;
import com.gft.productapi.dto.response.VendaResponseDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Vendas")
public interface VendaResourceDocs {

    @ApiOperation("Listar todas as vendas")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<Page<VendaResponseDto>> findAll(Pageable pageable);

    @ApiOperation("Buscar uma venda pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<VendaResponseDto> findById(@ApiParam(value = "Id de uma venda", example = "1") Long id);

    @ApiOperation("Buscar uma venda pelo nome do fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<VendaResponseDto> findByNome(@ApiParam(value = "Nome de um fornecedor", example = "1") String nome);

    @ApiOperation("Adicionar uma nova venda")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                      paramType = "header", example = "Bearer access_token")
    ResponseEntity<VendaResponseDto> update(@ApiParam(value = "Id de uma venda", example = "1") 
                                            Long id, 
                                            VendaRequestDto venda);

    @ApiOperation("Remove uma venda")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, 
                     paramType = "header", example = "Bearer access_token")
    void remove(Long id);
}

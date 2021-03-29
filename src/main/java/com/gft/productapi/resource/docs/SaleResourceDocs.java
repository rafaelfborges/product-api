package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.SaleRequestDto;
import com.gft.productapi.dto.response.SaleResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(tags = "Vendas")
public interface SaleResourceDocs {

    @ApiOperation("Listar todas as vendas")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    Page<SaleResponseDto> findAll(Pageable pageable);

    @ApiOperation("Buscar uma venda pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SaleResponseDto findById(@ApiParam(value = "Id de uma venda", example = "1") Long id);

    @ApiOperation("Buscar uma venda pelo nome do fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SaleResponseDto findByName(@ApiParam(value = "Nome de um fornecedor", example = "1") String name);

    @ApiOperation("Adiciona uma nova venda")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SaleResponseDto create(@Valid @RequestBody SaleRequestDto sale);

    @ApiOperation("Atualizar uma venda")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SaleResponseDto update(@ApiParam(value = "Id de uma venda", example = "1") Long id, SaleRequestDto sale);

    @ApiOperation("Remove uma venda")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    void remove(Long id);
}

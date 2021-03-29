package com.gft.productapi.resource.docs;

import com.gft.productapi.dto.request.SupplierRequestDto;
import com.gft.productapi.dto.response.SupplierResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "Fornecedores")
public interface SupplierResouceDocs {

    @ApiOperation("Listar todas os fornecedores")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    Page<SupplierResponseDto> findAll(Pageable pageable);

    @ApiOperation("Buscar um fornecedor pelo id")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SupplierResponseDto findById(@ApiParam(value = "Id de um fornecedor", example = "1") Long id);

    @ApiOperation("Buscar um fornecedor pelo nome")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SupplierResponseDto findByName(@ApiParam(value = "Nome de um fornecedor", example = "Amazon") String name);

    @ApiOperation("Adiciona um novo fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SupplierResponseDto create(SupplierRequestDto supplier);

    @ApiOperation("Atualiza um fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    SupplierResponseDto update(@ApiParam(value = "Id de um fornecedor", example = "1") Long id, SupplierRequestDto supplier);

    @ApiOperation("Remove um fornecedor")
    @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false,
            paramType = "header", example = "Bearer access_token")
    void remove(@PathVariable Long id);
}

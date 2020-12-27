package com.gft.productapi.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;

public interface ProductServiceInterface extends ServiceInterface<ProductResponseDto, ProdutoRequestDto> {
    
    BigDecimal somarTotalProdutos(List<Long> ids);

    void diminuirEstoqueProdutos(List<Long> ids);

    void verificarEstoqueProdutos(List<Long> ids);
}


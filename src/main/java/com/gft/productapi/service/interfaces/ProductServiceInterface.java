package com.gft.productapi.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.gft.productapi.dto.request.ProdutoRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;

public interface ProductServiceInterface extends ServiceInterface<ProductResponseDto, ProdutoRequestDto> {
    
    BigDecimal sumTotalProducts(List<Long> ids);

    void decreaseStockProducts(List<Long> ids);

    void verifyStockProducts(List<Long> ids);
}


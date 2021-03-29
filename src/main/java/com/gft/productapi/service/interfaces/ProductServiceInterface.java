package com.gft.productapi.service.interfaces;

import com.gft.productapi.dto.request.ProductRequestDto;
import com.gft.productapi.dto.response.ProductResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductServiceInterface extends ServiceInterface<ProductResponseDto, ProductRequestDto> {

    BigDecimal sumTotalProducts(List<Long> ids);

    void decreaseStockProducts(List<Long> ids);

    void verifyStockProducts(List<Long> ids);
}


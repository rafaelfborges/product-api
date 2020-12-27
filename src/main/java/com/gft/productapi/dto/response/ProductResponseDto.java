package com.gft.productapi.dto.response;

import java.math.BigDecimal;

import com.gft.productapi.dto.SupplierDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private String productCode;
    private BigDecimal value;
    private Boolean promotion;
    private BigDecimal promotionValue;
    private String category;
    private String image;
    private Long quantity;
    private SupplierDto supplier;
}

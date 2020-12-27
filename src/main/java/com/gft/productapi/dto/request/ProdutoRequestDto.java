package com.gft.productapi.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.gft.productapi.dto.SupplierDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String productCode;

    @NotNull
    @Positive
    private BigDecimal value;

    @NotNull
    private Boolean promotion;

    @PositiveOrZero
    private BigDecimal promotionValue;

    @NotBlank
    private String category;

    @NotBlank
    private String image;

    @NotNull
    @PositiveOrZero
    private Long quantity;

    @NotNull
    private SupplierDto supplier;
}

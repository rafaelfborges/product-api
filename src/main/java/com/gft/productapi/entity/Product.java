package com.gft.productapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @ManyToOne
    private Supplier supplier;

    public void decreaseQuantity() {
        if (this.quantity > 0)
            this.quantity--;
    }
}

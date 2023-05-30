package com.wishlist.api.entrypoint.api.dto;

import com.wishlist.api.core.domain.WishlistProduct;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ProductDTO(

    @Schema(description = "Nome do produto", example = "iphone")
    String name,
    @Schema(description = "Valor do produto", example = "4.599")
    String value) {

    public ProductDTO(final WishlistProduct wishlistProduct) {
        this(wishlistProduct.getName(), wishlistProduct.getValue().toString());
    }

    public WishlistProduct toDomain() {
        return WishlistProduct.builder()
            .name(name())
            .value(new BigDecimal(value()))
            .build();
    }

}

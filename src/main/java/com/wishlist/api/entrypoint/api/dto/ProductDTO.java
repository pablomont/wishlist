package com.wishlist.api.entrypoint.api.dto;

import com.wishlist.api.core.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;

public record ProductDTO(

    @Schema(description = "Nome do produto", example = "iphone")
    String name,
    @Schema(description = "Valor do produto", example = "4.599")
    String value) {

    public ProductDTO(final Product product) {
        this(product.getName(), product.getValue().toString());
    }

    public Product toDomain() {
        return Product.builder()
            .name(name())
            .value(Double.parseDouble(value()))
            .build();
    }

}

package com.wishlist.api.entrypoint.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ProductDTO(

    @Schema(description = "Nome do produto", example = "iphone")
    String name,
    @Schema(description = "Valor do produto", example = "4.599")
    String value) {

}

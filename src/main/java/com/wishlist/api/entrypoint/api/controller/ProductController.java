package com.wishlist.api.entrypoint.api.controller;

import com.wishlist.api.entrypoint.api.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Product")
public interface ProductController {

    @Operation(
        tags = "Product",
        summary = "Adicionar um produto na Wishlist do cliente")
    ResponseEntity<Void> addProductToWishlist(final ProductDTO productDto);


    @Operation(
        tags = "Product",
        summary = "Remover um produto da Wishlist do cliente")
    ResponseEntity<Void> removeProductToWishlist(final String productName);

    @Operation(
        tags = "Product",
        summary = "Consultar todos os produtos da Wishlist do cliente")
    ResponseEntity<List<ProductDTO>> getAllProductsInWishlist();

    @Operation(
        tags = "Product",
        summary = "Consultar se um determinado produto está na Wishlist do cliente")
    ResponseEntity<ProductDTO> getProductInWishlist(final String productName);

}

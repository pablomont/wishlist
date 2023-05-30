package com.wishlist.api.entrypoint.api.controller.impl;

import com.wishlist.api.core.usecase.AddWishlistProductUseCase;
import com.wishlist.api.core.usecase.FindWishlistProductsByNameUseCase;
import com.wishlist.api.core.usecase.FindWishlistProductsUseCase;
import com.wishlist.api.core.usecase.RemoveWishlistProductUseCase;
import com.wishlist.api.entrypoint.api.controller.ProductController;
import com.wishlist.api.entrypoint.api.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/products")
public class ProductControllerImpl implements ProductController {


    private final FindWishlistProductsByNameUseCase findWishlistProductsByNameUseCase;
    private final FindWishlistProductsUseCase findWishlistProductsUseCase;
    private final AddWishlistProductUseCase addWishlistProductUseCase;
    private final RemoveWishlistProductUseCase removeWishlistProductUseCase;

    @Override
    @PostMapping
    public ResponseEntity<Void> addProductToWishlist(@RequestHeader("consumer_id") final String consumerId, @RequestBody final ProductDTO productDto) {
        addWishlistProductUseCase.execute(productDto.toDomain(), consumerId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @DeleteMapping(value = "/{productName}")
    public ResponseEntity<Void> removeProductToWishlist(@RequestHeader("consumer_id") final String consumerId, @PathVariable final String productName) {

        removeWishlistProductUseCase.execute(consumerId, productName);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProductsInWishlist(@RequestHeader("consumer_id") final String consumerId) {
        return ResponseEntity.ok(findWishlistProductsUseCase.execute(consumerId).stream()
            .map(ProductDTO::new)
            .toList());
    }

    @Override
    @GetMapping(path = "/{productName}")
    public ResponseEntity<List<ProductDTO>> getProductsInWishlistByName(@RequestHeader("consumer_id") final String consumerId, @PathVariable final String productName) {
        return ResponseEntity.ok(findWishlistProductsByNameUseCase.execute(consumerId,productName).stream()
            .map(ProductDTO::new)
            .toList());
    }

}

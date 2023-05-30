package com.wishlist.api.entrypoint.api.controller.impl;

import com.wishlist.api.entrypoint.api.controller.ProductController;
import com.wishlist.api.entrypoint.api.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/products")
public class ProductControllerImpl implements ProductController {

    @Override
    @PostMapping
    public ResponseEntity<Void> addProductToWishlist(@RequestBody final ProductDTO productDto) {
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Void> removeProductToWishlist(@PathVariable final String productId) {
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProductsInWishlist() {
        return null;
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> getProductInWishlist(@PathVariable final String productId) {
        return null;
    }

}

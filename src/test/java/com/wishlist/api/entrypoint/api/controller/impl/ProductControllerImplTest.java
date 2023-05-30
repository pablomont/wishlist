package com.wishlist.api.entrypoint.api.controller.impl;

import com.wishlist.api.core.domain.Product;
import com.wishlist.api.core.usecase.AddWishlistProductUseCase;
import com.wishlist.api.core.usecase.FindWishlistProductUseCase;
import com.wishlist.api.core.usecase.FindWishlistProductsUseCase;
import com.wishlist.api.core.usecase.RemoveWishlistProductUseCase;
import com.wishlist.api.entrypoint.api.dto.ProductDTO;
import com.wishlist.api.utils.RecordFactory;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerImplTest {

    @Mock
    private FindWishlistProductUseCase findWishlistProductUseCase;
    @Mock
    private FindWishlistProductsUseCase findWishlistProductsUseCase;
    @Mock
    private AddWishlistProductUseCase addWishlistProductUseCase;
    @Mock
    private RemoveWishlistProductUseCase removeWishlistProductUseCase;

    @InjectMocks
    private ProductControllerImpl productController;

    private final EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters().objectFactory(new RecordFactory()));


    @Test
    @DisplayName("Should return all products")
    void testFindWishlistProducts() {
        final var productOne = easyRandom.nextObject(Product.class);
        final var productTwo = easyRandom.nextObject(Product.class);
        when(findWishlistProductsUseCase.execute()).thenReturn(List.of(productOne, productTwo));

        final var output = productController.getAllProductsInWishlist().getBody();
        verify(findWishlistProductsUseCase, only()).execute();
        assertEquals(2, output.size());
    }

    @Test
    @DisplayName("Should return a specific product")
    void testFindWishlistProduct() {
        final var product = easyRandom.nextObject(Product.class);
        when(findWishlistProductUseCase.execute(anyString())).thenReturn(product);

        final var output = productController.getProductInWishlist("iphone xr").getBody();
        verify(findWishlistProductUseCase, only()).execute(anyString());
        assertEquals(product.getName(), output.name());
    }

    @Test
    @DisplayName("Should return a success status code")
    void testAddWishlistProduct() {
        final var product = easyRandom.nextObject(Product.class);
        var productDTO = new ProductDTO(product);

        doNothing().when(addWishlistProductUseCase).execute(any());

        var statusCode = productController.addProductToWishlist(productDTO).getStatusCode();

        verify(addWishlistProductUseCase, only()).execute(any());
        assertEquals(HttpStatus.CREATED, statusCode);
    }

    @Test
    @DisplayName("Should return a no content status code")
    void testRemoveWishlistProduct() {

        doNothing().when(removeWishlistProductUseCase).execute(any());

        var statusCode = productController.removeProductToWishlist("iphone xr").getStatusCode();

        verify(removeWishlistProductUseCase, only()).execute(any());
        assertEquals(HttpStatus.NO_CONTENT, statusCode);
    }

}

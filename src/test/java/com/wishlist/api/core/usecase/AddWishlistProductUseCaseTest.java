package com.wishlist.api.core.usecase;

import com.wishlist.api.core.domain.WishlistProduct;
import com.wishlist.api.core.exception.WishlistException;
import com.wishlist.api.core.gateway.WishlistGateway;
import com.wishlist.api.utils.RecordFactory;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddWishlistProductUseCaseTest {

    @Mock
    private WishlistGateway wishlistGateway;
    @InjectMocks
    private AddWishlistProductUseCase addWishlistProductUseCase;

    private final EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters().objectFactory(new RecordFactory()));

    @Test
    @DisplayName("Should create a product with success")
    void testExecuteSuccess() {
        final var product = easyRandom.nextObject(WishlistProduct.class);
        when(wishlistGateway.findAllWishListProducts(anyString())).thenReturn(Optional.of(List.of(product)));
        doNothing().when(wishlistGateway).createWishListProduct(any(),anyString());
        addWishlistProductUseCase.execute(product,"123");

        verify(wishlistGateway, Mockito.times(1)).findAllWishListProducts(anyString());
        verify(wishlistGateway, Mockito.times(1)).createWishListProduct(any(),anyString());
    }

    @Test
    @DisplayName("Should thrown an exception when trying to create more than 20 products")
    void testExecuteError() {
        final var product = easyRandom.nextObject(WishlistProduct.class);
        var list = Collections.nCopies(20, product);
        when(wishlistGateway.findAllWishListProducts(anyString())).thenReturn(Optional.of(list));


        assertThrows(WishlistException.class, () -> addWishlistProductUseCase.execute(product,"123"));

        verify(wishlistGateway, Mockito.times(1)).findAllWishListProducts(anyString());
        verify(wishlistGateway, never()).createWishListProduct(any(),anyString());

    }

}

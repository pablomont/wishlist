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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindWishlistProductsByNameUseCaseTest {

    @Mock
    private WishlistGateway wishlistGateway;

    @InjectMocks
    private FindWishlistProductsByNameUseCase findWishlistProductsByNameUseCase;

    private final EasyRandom easyRandom = new EasyRandom(new EasyRandomParameters().objectFactory(new RecordFactory()));

    @Test
    @DisplayName("Should return a product with success")
    void testExecuteSuccess() {
        final var product = easyRandom.nextObject(WishlistProduct.class);
        when(wishlistGateway.findAllWishListProducts(anyString())).thenReturn(Optional.of(List.of(product)));

        var productsList = findWishlistProductsByNameUseCase.execute("123", product.getName());
        assertEquals(1, productsList.size());
        assertEquals(productsList.get(0).getName(),product.getName());
    }

    @Test
    @DisplayName("Should thrown an exception when getting products from a consumer without products")
    void testExecuteErrorConsumerWithoutProducts() {

        when(wishlistGateway.findAllWishListProducts(anyString())).thenReturn(Optional.empty());

        assertThrows(WishlistException.class, () -> findWishlistProductsByNameUseCase.execute("123", "name"));

    }

    @Test
    @DisplayName("Should thrown an exception when getting products from a consumer that doesn't have products with the name passed ")
    void testExecuteErrorConsumerWithoutProductsByName() {

        final var product = easyRandom.nextObject(WishlistProduct.class);
        when(wishlistGateway.findAllWishListProducts(anyString())).thenReturn(Optional.of(List.of(product)));

        assertThrows(WishlistException.class, () -> findWishlistProductsByNameUseCase.execute("123", "name"));

    }

}

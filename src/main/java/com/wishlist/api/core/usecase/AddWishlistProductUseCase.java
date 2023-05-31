package com.wishlist.api.core.usecase;

import com.wishlist.api.core.domain.WishlistProduct;
import com.wishlist.api.core.exception.WishlistException;
import com.wishlist.api.core.gateway.WishlistGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddWishlistProductUseCase {

    public static final int MAX_LIMIT_NUMBER = 20;
    private final WishlistGateway wishlistGateway;

    public void execute(WishlistProduct wishlistProduct, String consumerId) {

        wishlistGateway.findAllWishListProducts(consumerId)
            .filter(wishlistProducts -> wishlistProducts.size() < MAX_LIMIT_NUMBER)
            .ifPresentOrElse(wishlistProducts -> wishlistGateway.createWishListProduct(wishlistProduct, consumerId),
                () -> {throw new WishlistException("Maximum limit reached", HttpStatus.INSUFFICIENT_STORAGE);});
    }

}

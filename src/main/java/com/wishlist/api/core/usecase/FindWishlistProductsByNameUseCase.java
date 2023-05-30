package com.wishlist.api.core.usecase;

import com.wishlist.api.core.domain.WishlistProduct;
import com.wishlist.api.core.exception.WishlistException;
import com.wishlist.api.core.gateway.WishlistGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindWishlistProductsByNameUseCase {

    private final WishlistGateway wishlistGateway;

    public List<WishlistProduct> execute(String consumerId, String productName) {

        return wishlistGateway.findAllWishListProducts(consumerId)
            .map(wishlistProducts -> wishlistProducts.stream().filter(wishlistProduct -> wishlistProduct.getName().equals(productName)).toList())
            .orElseThrow(() -> new WishlistException("Product not found", HttpStatus.NOT_FOUND));
    }

}

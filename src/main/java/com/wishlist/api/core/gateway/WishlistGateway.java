package com.wishlist.api.core.gateway;

import com.wishlist.api.core.domain.WishlistProduct;

import java.util.List;
import java.util.Optional;

public interface WishlistGateway {
    void createWishListProduct(WishlistProduct wishlistProduct, String consumerId);
    void deleteWishListProductById(String consumerId, String productName);
    Optional<List<WishlistProduct>> findAllWishListProducts(String consumerId);
}

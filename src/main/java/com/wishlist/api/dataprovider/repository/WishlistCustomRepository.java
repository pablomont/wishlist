package com.wishlist.api.dataprovider.repository;

import com.wishlist.api.dataprovider.entity.WishlistProductEntity;

public interface WishlistCustomRepository {
    void pushWishListProduct(String consumerId, WishlistProductEntity product);
    void pullWishListProduct(String consumerId, WishlistProductEntity product);
}

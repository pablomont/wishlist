package com.wishlist.api.core.usecase;

import com.wishlist.api.core.domain.Product;

public class FindWishlistProductUseCase {
    public Product execute(String productName){
        return Product.builder().build();
    }
}

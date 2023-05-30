package com.wishlist.api.core.usecase;

import com.wishlist.api.core.domain.Product;

import java.util.List;

public class FindWishlistProductsUseCase {

    public List<Product> execute(){
        return List.of(Product.builder().build());
    }

}

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
public class FindWishlistProductsUseCase {

    private final WishlistGateway wishlistGateway;

    public List<WishlistProduct> execute(String consumerId){

        return wishlistGateway.findAllWishListProducts(consumerId)
            .orElseThrow(() -> new WishlistException("Not found any product", HttpStatus.NOT_FOUND));

    }

}

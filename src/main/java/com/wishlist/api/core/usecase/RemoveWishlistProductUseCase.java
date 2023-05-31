package com.wishlist.api.core.usecase;

import com.wishlist.api.core.gateway.WishlistGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RemoveWishlistProductUseCase {

    private final WishlistGateway wishlistGateway;

    public void execute(String consumerId, String productName){
        wishlistGateway.deleteWishListProductByName(consumerId, productName);
    }
}

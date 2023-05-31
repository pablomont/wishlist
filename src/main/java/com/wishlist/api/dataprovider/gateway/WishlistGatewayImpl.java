package com.wishlist.api.dataprovider.gateway;

import com.wishlist.api.core.domain.WishlistProduct;
import com.wishlist.api.core.gateway.WishlistGateway;
import com.wishlist.api.dataprovider.entity.WishlistEntity;
import com.wishlist.api.dataprovider.entity.WishlistProductEntity;
import com.wishlist.api.dataprovider.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class WishlistGatewayImpl implements WishlistGateway {

    private final WishlistRepository wishlistRepository;


    @Override
    public void createWishListProduct(final WishlistProduct wishlistProduct, final String consumerId) {
        log.info("Saving wishlistProduct in database, consumer: {}", consumerId);
        wishlistRepository.pushWishListProduct(consumerId, buildWishlistProductEntity(wishlistProduct));
    }

    @Override
    public void deleteWishListProductByName(final String consumerId, final String productName) {
        log.info("Deleting wishlistProduct in database, name: {}", productName);
        wishlistRepository.pullWishListProduct(consumerId, WishlistProductEntity.builder().name(productName).build());
    }

    @Override
    public Optional<List<WishlistProduct>> findAllWishListProducts(final String consumerId) {
        log.info("Returning all wishlistProduct in database, consumerId: {}", consumerId);
        return wishlistRepository.findByConsumerId(consumerId).map(WishlistGatewayImpl::getWishlistProducts);
    }

    private static List<WishlistProduct> getWishlistProducts(final WishlistEntity wishlistEntity) {
        return wishlistEntity.getProducts().stream().map(
            WishlistProductEntity::toDomain).toList();
    }

    private static WishlistProductEntity buildWishlistProductEntity(final WishlistProduct wishlistProduct) {
        return WishlistProductEntity.builder()
            .name(wishlistProduct.getName())
            .value(wishlistProduct.getValue())
            .build();
    }

}

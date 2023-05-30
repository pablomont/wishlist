package com.wishlist.api.dataprovider.repository.impl;

import com.wishlist.api.dataprovider.entity.WishlistProductEntity;
import com.wishlist.api.dataprovider.repository.WishlistCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@RequiredArgsConstructor
public class WishlistCustomRepositoryImpl implements WishlistCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public void pushWishListProduct(final String consumerId, final WishlistProductEntity product) {
        Query query = new Query(Criteria.where("consumerId").is(consumerId));
        Update update = new Update().addToSet("products", product);
        mongoTemplate.upsert(query, update, "wishlist");
    }

    @Override
    public void pullWishListProduct(final String consumerId, final WishlistProductEntity product) {
        Query query = new Query(Criteria.where("consumerId").is(consumerId));
        Update update = new Update().pull("products", product);
        mongoTemplate.upsert(query, update, "wishlist");

    }

}

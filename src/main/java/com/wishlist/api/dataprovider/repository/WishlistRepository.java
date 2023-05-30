package com.wishlist.api.dataprovider.repository;

import com.wishlist.api.dataprovider.entity.WishlistEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends MongoRepository<WishlistEntity, String>, WishlistCustomRepository {

    Optional<WishlistEntity> findByConsumerId(String consumerId);

}

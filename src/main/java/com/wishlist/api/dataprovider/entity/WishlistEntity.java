package com.wishlist.api.dataprovider.entity;

import lombok.Builder;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Builder
@Document(collection = "wishlist")
public class WishlistEntity {
    @Id
    private String id;
    @Indexed
    private String consumerId;
    private List<WishlistProductEntity> products;

}

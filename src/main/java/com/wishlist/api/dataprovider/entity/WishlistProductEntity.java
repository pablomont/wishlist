package com.wishlist.api.dataprovider.entity;

import com.wishlist.api.core.domain.WishlistProduct;
import lombok.Builder;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;

@Builder
public class WishlistProductEntity {


    @Indexed
    private String name;
    private BigDecimal value;

    public WishlistProduct toDomain() {
        return WishlistProduct.builder()
            .name(name)
            .value(value)
            .build();
    }

}

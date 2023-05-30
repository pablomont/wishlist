package com.wishlist.api.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Getter
@Slf4j
@RequiredArgsConstructor
@Builder
public class WishlistProduct {
    private final String name;
    private final BigDecimal value;

}

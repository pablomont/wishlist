package com.wishlist.api.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Builder
@RequiredArgsConstructor
@Slf4j
public class Product {
    private String name;
    private Double value;
}

package com.wishlist.api.entrypoint.api.dto;

import lombok.Builder;

@Builder
public record ResponseErrorDTO(String message) {

}

package com.wishlist.api.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class WishlistException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

}

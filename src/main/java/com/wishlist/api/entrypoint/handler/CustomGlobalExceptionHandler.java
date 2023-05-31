package com.wishlist.api.entrypoint.handler;

import com.wishlist.api.core.exception.WishlistException;
import com.wishlist.api.entrypoint.api.dto.ResponseErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WishlistException.class)
    public ResponseEntity<ResponseErrorDTO> handleWishlistException(WishlistException ex) {

        var error = buildExceptionOutput(ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(error);
    }

    private ResponseErrorDTO buildExceptionOutput(final String message) {
        return ResponseErrorDTO.builder()
            .message(message)
            .build();
    }

}

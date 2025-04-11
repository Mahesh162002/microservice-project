package com.user.exception;

import com.user.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        String msg = ex.getMessage();
        ApiResponse.ApiResponseBuilder builder = ApiResponse.builder();
        builder.message(msg);
        builder.success(true);
        builder.status(HttpStatus.NOT_FOUND);
        ApiResponse response = builder
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

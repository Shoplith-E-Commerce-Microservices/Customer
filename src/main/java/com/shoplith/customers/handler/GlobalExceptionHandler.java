package com.shoplith.customers.handler;

import com.shoplith.customers.exceptions.ProfileAlreadyExistException;
import com.shoplith.customers.exceptions.ProfileNotFoundException;
import com.shoplith.customers.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleUserNotFound(ProfileNotFoundException ex) {
        return ResponseEntity.status(404)
                .body(new ApiResponse<>(404, ex.getMessage(), ApiResponse.Status.ERROR));
    }

    @ExceptionHandler(ProfileAlreadyExistException.class)
    public ResponseEntity<ApiResponse<String>> handleUserAlreadyExist(ProfileAlreadyExistException ex) {
        return ResponseEntity.status(409)
                .body(new ApiResponse<>(409, ex.getMessage(), ApiResponse.Status.ERROR));
    }

}

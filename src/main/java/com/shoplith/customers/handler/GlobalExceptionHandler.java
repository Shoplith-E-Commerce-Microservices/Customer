package com.shoplith.customers.handler;

import com.shoplith.customers.exceptions.UserAlreadyExistException;
import com.shoplith.customers.exceptions.UserNotFoundException;
import com.shoplith.customers.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(404)
                .body(new ApiResponse<>(404, ex.getMessage(), ApiResponse.Status.ERROR));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ApiResponse<String>> handleUserAlreadyExist(UserAlreadyExistException ex) {
        return ResponseEntity.status(409)
                .body(new ApiResponse<>(409, ex.getMessage(), ApiResponse.Status.ERROR));
    }

}

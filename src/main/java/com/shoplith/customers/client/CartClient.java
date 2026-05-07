package com.shoplith.customers.client;

import com.shoplith.customers.payload.CartPayload;
import com.shoplith.customers.response.ApiResponse;
import com.shoplith.customers.response.CartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "cart-service",path = "/cart-app/api")
public interface CartClient {

    @PostMapping("/v1/cart")
    public ResponseEntity<ApiResponse<CartResponse>> createCart(@RequestBody CartPayload payload);



}

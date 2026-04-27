package com.shoplith.customers.client;

import com.shoplith.customers.payload.CartPayload;
import com.shoplith.customers.response.ApiResponse;
import com.shoplith.customers.response.CartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;
import java.util.UUID;

@FeignClient(name = "CartClient",url = "http://localhost:8003/api/v1")
public interface CartClient {

    @PostMapping("/cart")
    public ApiResponse<CartResponse> createCart(@RequestBody CartPayload payload);



}

package com.shoplith.customers.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CartPayload {

    private UUID user_id;

}

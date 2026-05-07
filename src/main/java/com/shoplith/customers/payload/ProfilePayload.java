package com.shoplith.customers.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProfilePayload {

    private UUID userId;
    private String email;
    private String name;


}

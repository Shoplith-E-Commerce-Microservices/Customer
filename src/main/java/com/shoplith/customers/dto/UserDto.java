package com.shoplith.customers.dto;

import com.shoplith.customers.models.Address;
import com.shoplith.customers.models.Profile;
import com.shoplith.customers.response.CartResponse;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private UUID id;
    private String email;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Profile profile;
    private List<Address> address;
    private CartResponse cart;


}

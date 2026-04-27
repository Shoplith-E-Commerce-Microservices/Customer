package com.shoplith.customers.mapper;

import com.shoplith.customers.dto.UserDto;
import com.shoplith.customers.models.Users;
import com.shoplith.customers.response.CartResponse;

public class UserMapper {

    public static UserDto mapUserToUserDto(Users user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setProfile(user.getProfile());
        dto.setAddress(user.getUserAddress());
        return dto;
    }
    public static UserDto mapUserToUserDto(Users user, CartResponse cartResponse){
        UserDto dto = mapUserToUserDto(user);
        dto.setCart(cartResponse);
        return dto;
    }

    public static UserDto mapAuthUserToAuthUserDto(Users user,String accessToken,String refreshToken){
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setAccessToken(accessToken);
        dto.setRefreshToken(refreshToken);
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setProfile(user.getProfile());
        dto.setAddress(user.getUserAddress());
        return dto;
    }

}

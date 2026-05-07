package com.shoplith.customers.mapper;

import com.shoplith.customers.dto.ProfileDto;
import com.shoplith.customers.models.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileMapper {

    public static ProfileDto mapToProfileDto(Profile profile){
        ProfileDto dto = new ProfileDto();
        dto.setId(profile.getId());
        dto.setName(profile.getName());
        dto.setAddress(profile.getAddress());
        dto.setNumber(profile.getNumber());
        dto.setEmail(profile.getEmail());
        dto.setCreatedAt(profile.getCreatedAt());
        dto.setUpdatedAt(profile.getUpdatedAt());
        dto.setUser_id(profile.getUser_id());
        return dto;
    }

}

package com.shoplith.customers.services.profile;

import com.shoplith.customers.dto.ProfileDto;
import com.shoplith.customers.payload.ProfilePayload;

import java.util.UUID;

public interface ProfileService {

    public ProfileDto createProfile(ProfilePayload payload);
    public ProfileDto getProfileByUserIddd();

}

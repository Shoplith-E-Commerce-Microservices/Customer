package com.shoplith.customers.services.profile;

import com.shoplith.customers.dto.ProfileDto;
import com.shoplith.customers.exceptions.ProfileAlreadyExistException;
import com.shoplith.customers.mapper.ProfileMapper;
import com.shoplith.customers.models.Profile;
import com.shoplith.customers.payload.ProfilePayload;
import com.shoplith.customers.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository profileRepository;

    @Override
    public ProfileDto createProfile(ProfilePayload payload) {
        if(profileRepository.findByUserId(payload.getUserId()).isPresent()){
            throw new ProfileAlreadyExistException("Profile already exist");
        }
        Profile profile = new Profile();
        profile.setName(payload.getName());
        profile.setEmail(payload.getEmail());
        profile.setUser_id(payload.getUserId());
        profile.setImageUrl(null);
        profile.setName(profile.getName());
        profile.setAddress(null);
        profile.setNumber("");
        profileRepository.save(profile);
        return ProfileMapper.mapToProfileDto(profileRepository.save(profile));
    }
}

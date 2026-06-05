package com.shoplith.customers.services.profile;

import com.nimbusds.jwt.JWT;
import com.shoplith.customers.dto.ProfileDto;
import com.shoplith.customers.exceptions.ProfileAlreadyExistException;
import com.shoplith.customers.exceptions.ProfileNotFoundException;
import com.shoplith.customers.mapper.ProfileMapper;
import com.shoplith.customers.models.Profile;
import com.shoplith.customers.payload.ProfilePayload;
import com.shoplith.customers.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.UUID;


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

    public ProfileDto getProfileByUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof JwtAuthenticationToken token) {
          // these data just for my reference
            Jwt jwt = token.getToken();
            // Raw JWT token
            String accessToken = jwt.getTokenValue();
            System.out.println("Access Token: " + accessToken);
            // All claims
            System.out.println("Claims: " + jwt.getClaims());
            // Subject (usually userId)
            System.out.println("Subject: " + jwt.getSubject());
            System.out.println("UUID: " + jwt.getClaimAsString("uuid"));
            String  uuid = jwt.getClaimAsString("uuid");
            String  username = jwt.getClaimAsString("username");

            Profile profileData = profileRepository.findByUserId(UUID.fromString(uuid)).orElseThrow(()-> new ProfileNotFoundException("Profile doesn't exist"));
            ProfileDto dtoData =  new ProfileDto();
            dtoData.setName(profileData.getName());
            dtoData.setEmail(profileData.getEmail());
            dtoData.setAddress(profileData.getAddress());
            dtoData.setImageUrl(profileData.getImageUrl());
            dtoData.setCreatedAt(profileData.getCreatedAt());
            dtoData.setUpdatedAt(profileData.getUpdatedAt());
            dtoData.setNumber(profileData.getNumber());
            dtoData.setUsername(username);
            return dtoData;
        }

        return null;
    }
}

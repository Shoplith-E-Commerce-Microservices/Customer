package com.shoplith.customers.controllers;


import com.shoplith.customers.dto.ProfileDto;
import com.shoplith.customers.payload.ProfilePayload;
import com.shoplith.customers.response.ApiResponse;
import com.shoplith.customers.services.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/customers/me")
    public ResponseEntity<ApiResponse<ProfileDto>> createProfile(@RequestBody  ProfilePayload payload){
        System.out.println("Calling customer api ");
        try{
            return ResponseEntity.status(201).body(new ApiResponse<>(201,"Profile has been created successfully", ApiResponse.Status.SUCCESS,profileService.createProfile(payload)));
        }catch (Exception e){
            return ResponseEntity.status(201).body(new ApiResponse<>(500,e.getMessage(), ApiResponse.Status.ERROR));

        }
    }

}

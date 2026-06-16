package com.shoplith.customers.consumer;

import com.shoplith.customers.events.CustomerProfileCreateEvent;
import com.shoplith.customers.models.Profile;
import com.shoplith.customers.payload.ProfilePayload;
import com.shoplith.customers.repositories.ProfileRepository;
import com.shoplith.customers.services.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateProfileConsumer {

    private final ProfileService profileService;
    private final ProfileRepository profileRepository;


    @KafkaListener(topics = "user-profile-registration",groupId = "customer-group")
    public void CreateProfileConsumer(CustomerProfileCreateEvent event){

        Profile profile = new Profile();
        profile.setName(event.name());
        profile.setEmail(event.email());
        profile.setUser_id(UUID.fromString(event.userId()));
        profile.setAddress(null);
        profile.setImageUrl(null);
        profile.setNumber(null);
        profileRepository.save(profile);

    }




}

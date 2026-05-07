package com.shoplith.customers.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shoplith.customers.models.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProfileDto {

    private UUID id;
    private String name;
    private String email;
    private String imageUrl;
    private String number;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID user_id;
    private List<Address> address;

}

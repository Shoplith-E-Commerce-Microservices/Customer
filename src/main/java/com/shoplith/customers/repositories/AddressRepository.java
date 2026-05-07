package com.shoplith.customers.repositories;

import com.shoplith.customers.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Profile, UUID> {
}

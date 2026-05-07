package com.shoplith.customers.repositories;

import com.shoplith.customers.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    public Optional<Profile> findByEmail(String email);
    @Query(value = "select * from profile where user_id= :userId",nativeQuery = true)
    public Optional<Profile>  findByUserId(@Param("userId") UUID userId);



}

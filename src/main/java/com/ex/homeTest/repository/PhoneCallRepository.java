package com.ex.homeTest.repository;

import com.ex.homeTest.entity.PhoneCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneCallRepository extends JpaRepository<PhoneCall,Integer> {

    @Query(value = "SELECT * FROM phone_calls p WHERE p.duration > :duration", nativeQuery = true)
    List<PhoneCall> getPhoneCallsWithDurationGreaterThan(@Param("duration") int duration);

    @Modifying
    @Query(value = "UPDATE phone_calls SET phone_number = :newPhoneNumber WHERE phone_number = :oldPhoneNumber", nativeQuery = true)
    void updatePhoneNumbers(@Param("oldPhoneNumber") String oldPhoneNumber, @Param("newPhoneNumber") String newPhoneNumber);

    @Query(value = "SELECT * FROM phone_calls p WHERE p.phone_number = :phoneNumber", nativeQuery = true)
    List<PhoneCall> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}

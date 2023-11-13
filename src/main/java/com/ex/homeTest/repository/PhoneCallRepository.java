package com.ex.homeTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneCallRepository extends JpaRepository<PhoneCall,Integer> {

    @Query(value = "SELECT * FROM phone_calls p WHERE p.duration > :duration", nativeQuery = true)
    List<PhoneCall> getPhoneCallsWithDurationGreaterThan(@Param("duration") int duration);

    @Query(value = "SELECT * FROM phone_calls p WHERE p.phone_number = :phoneNumber", nativeQuery = true)
    List<PhoneCall> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}

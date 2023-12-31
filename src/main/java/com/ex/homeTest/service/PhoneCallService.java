package com.ex.homeTest.service;

import com.ex.homeTest.entity.PhoneCall;

import java.util.List;

public interface PhoneCallService {

    List<PhoneCall> findByPhoneNumber(String phoneNumber);
    List<PhoneCall> findAll();
    void save(PhoneCall thePhoneCall);
    List<PhoneCall> getPhoneCallsWithDurationGreaterThan(int duration);

    void updatePhoneNumbers(String oldNumber,String newNumber);
}

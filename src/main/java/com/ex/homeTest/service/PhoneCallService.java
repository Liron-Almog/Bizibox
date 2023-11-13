package com.ex.homeTest.service;

import com.ex.homeTest.repository.PhoneCall;

import java.util.List;

public interface PhoneCallService {

    List<PhoneCall> findByPhoneNumber(String phoneNumber);
    List<PhoneCall> findAll();

    List<PhoneCall> getPhoneCallsWithDurationGreaterThan(int duration);
}

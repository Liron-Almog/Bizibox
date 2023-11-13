package com.ex.homeTest.service;

import com.ex.homeTest.repository.PhoneCall;
import com.ex.homeTest.repository.PhoneCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneCallServiceImpl implements PhoneCallService {

    private PhoneCallRepository phoneCallRepository;

    @Autowired
    public PhoneCallServiceImpl(PhoneCallRepository phoneCallRepository) {
        this.phoneCallRepository = phoneCallRepository;
    }

    @Override
    public List<PhoneCall> findByPhoneNumber(String phoneNumber) {
        return phoneCallRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<PhoneCall> findAll() {
        return phoneCallRepository.findAll();
    }

    @Override
    public List<PhoneCall> getPhoneCallsWithDurationGreaterThan(int duration) {
        return phoneCallRepository.getPhoneCallsWithDurationGreaterThan(duration);
    }


}

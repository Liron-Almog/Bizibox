package com.ex.homeTest.service;

import com.ex.homeTest.entity.PhoneCall;
import com.ex.homeTest.repository.PhoneCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void save(PhoneCall thePhoneCall) {
        phoneCallRepository.save(thePhoneCall);
    }

    @Override
    public List<PhoneCall> getPhoneCallsWithDurationGreaterThan(int duration) {
        return phoneCallRepository.getPhoneCallsWithDurationGreaterThan(duration);
    }

    @Transactional
    @Override
    public void updatePhoneNumbers(String oldPhoneNumber, String newPhoneNumber) {
        phoneCallRepository.updatePhoneNumbers(oldPhoneNumber,newPhoneNumber);
    }

}

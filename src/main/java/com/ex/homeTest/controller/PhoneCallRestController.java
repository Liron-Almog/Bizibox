package com.ex.homeTest.controller;

import com.ex.homeTest.exception.ThePhoneCallInTheBlackListException;
import com.ex.homeTest.model.PhoneCallPOJO;
import com.ex.homeTest.repository.PhoneCall;
import com.ex.homeTest.service.PhoneCallServiceImpl;
import com.ex.homeTest.service.ValidationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneCallRestController {

    @Autowired
    private PhoneCallServiceImpl phoneCallService;
    @Autowired
    private ValidationService validationService;

     @PostMapping("/phone-call")
     public void addPhoneCall(@RequestBody PhoneCallPOJO thePhoneCall)
     {
         if(validationService.isExistInBlackList(thePhoneCall.getPhoneNumber()))
             throw new ThePhoneCallInTheBlackListException("Phone call is in the blacklist");;

         ModelMapper modelMapper = new ModelMapper();
         PhoneCall TheNewphoneCall = modelMapper.map(thePhoneCall,PhoneCall.class);

         if(validationService.isExistInPhoneBook(TheNewphoneCall.getPhoneNumber()))
             TheNewphoneCall.setSavedContact(true);

         phoneCallService.save(TheNewphoneCall);

         return;
     }

    @GetMapping("/phone-call/{phoneNumber}")
    public List<PhoneCall> getSpecificPhoneCall(@PathVariable String phoneNumber) {
         return phoneCallService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/phone-call/duration/{duration}")
    public List<PhoneCall> getPhoneCallsWithDurationGreaterThan(@PathVariable int duration) {
        return phoneCallService.getPhoneCallsWithDurationGreaterThan(duration);
    }
}

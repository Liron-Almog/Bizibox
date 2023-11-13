package com.ex.homeTest.controller;

import com.ex.homeTest.model.PhoneCallPOJO;
import com.ex.homeTest.repository.PhoneCall;
import com.ex.homeTest.service.PhoneCallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneCallRestController {

    @Autowired
    private PhoneCallServiceImpl phoneCallService;

     @PostMapping("/phone-call")
     public void addPhoneCall(@RequestBody PhoneCallPOJO thePhoneCall)
     {
         System.out.println(thePhoneCall.getPhoneNumber());
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

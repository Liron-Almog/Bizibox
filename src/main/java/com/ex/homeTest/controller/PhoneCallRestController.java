package com.ex.homeTest.controller;

import com.ex.homeTest.exception.ThePhoneNumberInTheBlackListException;
import com.ex.homeTest.dto.PhoneCallPDTO;
import com.ex.homeTest.dto.PhoneCallUpdateDTO;
import com.ex.homeTest.entity.PhoneCall;
import com.ex.homeTest.service.BlackListFileService;
import com.ex.homeTest.service.PhoneBookFileService;
import com.ex.homeTest.service.PhoneCallServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneCallRestController {

    @Autowired
    private BlackListFileService blackListFileService;
    @Autowired
    private PhoneCallServiceImpl phoneCallService;
    @Autowired
    private PhoneBookFileService phoneBookFileService;

     @PostMapping("/phone-call")
     public void addPhoneCall(@RequestBody PhoneCallPDTO thePhoneCall)
     {
         if(blackListFileService.isExistInFile(thePhoneCall.getPhoneNumber()))
             throw new ThePhoneNumberInTheBlackListException("Phone call is in the blacklist");;

         ModelMapper modelMapper = new ModelMapper();
         PhoneCall TheNewphoneCall = modelMapper.map(thePhoneCall,PhoneCall.class);

         if(phoneBookFileService.isExistInFile(TheNewphoneCall.getPhoneNumber()))
             TheNewphoneCall.setSavedContact(true);

         phoneCallService.save(TheNewphoneCall);
     }

    @GetMapping("/phone-call/{phoneNumber}")
    public List<PhoneCall> getSpecificPhoneCall(@PathVariable String phoneNumber) {
         return phoneCallService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("/phone-call/duration/{duration}")
    public List<PhoneCall> getPhoneCallsWithDurationGreaterThan(@PathVariable int duration) {
        return phoneCallService.getPhoneCallsWithDurationGreaterThan(duration);
    }

    @PutMapping("/phone-call")
    public void updatePhone(@RequestBody PhoneCallUpdateDTO thePhoneCallUpdateDTO){
         phoneCallService.updatePhoneNumbers(thePhoneCallUpdateDTO.getOldPhoneNumber(),
                                             thePhoneCallUpdateDTO.getNewPhoneNumber());
    }

}

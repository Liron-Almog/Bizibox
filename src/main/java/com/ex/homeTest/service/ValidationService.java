package com.ex.homeTest.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Service
public class ValidationService {

    private HashSet<String> blackList;
    private Map<String, String> phoneBook;
    public ValidationService() {
        blackList = new HashSet<>();
        phoneBook = new HashMap<>();

        // Add entries to the phone book
        phoneBook.put("513153847", "moshe");
        phoneBook.put("518617755", "david");
        phoneBook.put("596580283", "dana");
        phoneBook.put("594372654", "michal");
        phoneBook.put("511142653", "erez");
        phoneBook.put("598558770", "guy");

        blackList.add("560265187");
        blackList.add("563803925");
        blackList.add("510888303");
        blackList.add("567457626");
        blackList.add("595760680");
    }
    public boolean isExistInBlackList(String numberToCheck) {
        return blackList.contains(numberToCheck);
    }
    public boolean isExistInPhoneBook(String numberToCheck) {
        return phoneBook.containsKey(numberToCheck);
    }
    // Other methods for your service...
}

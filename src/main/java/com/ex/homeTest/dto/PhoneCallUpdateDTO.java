package com.ex.homeTest.dto;

public class PhoneCallUpdateDTO {

    private String oldPhoneNumber;
    private String newPhoneNumber;

    public PhoneCallUpdateDTO() {}

    public String getOldPhoneNumber() {
        return oldPhoneNumber;
    }

    public void setOldPhoneNumber(String oldPhoneNumber) {
        this.oldPhoneNumber = oldPhoneNumber;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }
    public void setNewPhoneNumber(String newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }
}

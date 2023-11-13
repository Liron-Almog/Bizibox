package com.ex.homeTest.dto;

public class PhoneCallPDTO {

    private String time;

    private String callType;

    private String duration;

    private String phoneNumber;

    public PhoneCallPDTO(String time, String callType, String duration, String phoneNumber) {
        this.time = time;
        this.callType = callType;
        this.duration = duration;
        this.phoneNumber = phoneNumber;
    }

    public PhoneCallPDTO() {}

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}



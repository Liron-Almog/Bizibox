package com.ex.homeTest.entity;


//POJO class to represent entity PhoneCall

import javax.persistence.*;

@Entity
@Table(name = "phone_calls")
public class PhoneCall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "time")
    private String time;

    @Column(name = "call_type")
    private String callType;

    @Column(name = "duration")
    private int duration;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "saved_contact")
    private boolean savedContact =false;

    public PhoneCall(){}

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public boolean isSavedContact() {
        return savedContact;
    }

    public void setSavedContact(boolean savedContact) {
        this.savedContact = savedContact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package com.softgroup.common.protocol.DTO;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class DTOContact {
    //phone number
    private ArrayList<String> phoneNumber;
    //contact name
    private	String name;

    public ArrayList<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(ArrayList<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

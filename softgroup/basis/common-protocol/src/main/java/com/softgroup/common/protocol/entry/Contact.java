package com.softgroup.common.protocol.entry;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class Contact {
    //номера телефонов
    private ArrayList<String> phoneNumber;
    //имя контакта
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

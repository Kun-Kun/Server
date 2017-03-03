package com.softgroup.common.protocol.entry;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class Contact {
    //номера телефонов
    private ArrayList<String> phone_number;
    //имя контакта
    private	String name;

    public ArrayList<String> getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(ArrayList<String> phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.softgroup.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class DTOContact implements Serializable{

    private static final long serialVersionUID = 2910456215250546254L;
    //phone number
    private List<String> phoneNumber;
    //contact name
    private	String name;

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

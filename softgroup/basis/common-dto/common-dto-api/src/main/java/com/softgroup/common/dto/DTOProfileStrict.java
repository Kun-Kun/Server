package com.softgroup.common.dto;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOProfileStrict implements Serializable{

    private static final long serialVersionUID = -929487802895351475L;
    //key
    private	String	id;
    //full phone number
    private	String phoneNumber;
    //username
    private	String	name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

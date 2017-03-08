package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class ProfileStrict {
    //ключ
    private	String	id;
    //полный номер телефона
    private	String phoneNumber;
    //имя пользователя
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

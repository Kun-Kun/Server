package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class ProfileStrict {
    //ключ
    private	String	id;
    //полный номер телефона
    private	String	phone_number;
    //имя пользователя
    private	String	name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

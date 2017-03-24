package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "contacts")
public class ContactEntity implements Serializable{

    private static final long serialVersionUID = 3442338683584269763L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

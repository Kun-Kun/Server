package com.softgroup.common.dto;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOConversationSettings implements Serializable {

    private static final long serialVersionUID = -4957502370055743930L;
    //Conversation
    private String id;
    //id admin user
    private String adminId;
    //conversation name
    private String name;
    //conversation logo
    private String logoImageUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }



}

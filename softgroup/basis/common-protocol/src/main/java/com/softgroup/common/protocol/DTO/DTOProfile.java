package com.softgroup.common.protocol.DTO;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOProfile implements Serializable{

    private static final long serialVersionUID = -6540825380103826313L;
    //key
    private	String	id;
    //full phone number
    private	String phoneNumber;
    //registration date
    private	Long createDateTime;
    //last change date
    private	Long updateDateTime;
    //link to user avatar
    private	String avatarUri;
    //username
    private	String	name;
    ///user status
    private	String	status;

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

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

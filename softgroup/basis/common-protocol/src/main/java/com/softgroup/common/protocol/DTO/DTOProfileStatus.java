package com.softgroup.common.protocol.DTO;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOProfileStatus implements Serializable{

    private static final long serialVersionUID = 7902087093258662196L;
    //key <Profile>
    private	String id;
    //is user online
    private	Boolean isOnline;
    //last time online
    private	Long lastTimeOnline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public Long getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Long lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }
}

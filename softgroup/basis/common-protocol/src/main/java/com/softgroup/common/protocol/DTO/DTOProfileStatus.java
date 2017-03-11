package com.softgroup.common.protocol.DTO;

/**
 * Created by user on 26.02.2017.
 */
public class DTOProfileStatus {
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

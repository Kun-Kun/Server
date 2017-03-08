package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class ProfileStatus {
    //ключ <Profile>
    private	String id;
    //Или в онлайне
    private	Boolean isOnline;
    //Последний раз в онлайне
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

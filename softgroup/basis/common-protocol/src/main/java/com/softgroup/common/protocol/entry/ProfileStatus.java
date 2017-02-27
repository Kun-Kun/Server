package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class ProfileStatus {
    //ключ <Profile>
    private	String id;
    //Или в онлайне
    private	Boolean is_online;
    //Последний раз в онлайне
    private	Long last_time_online;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIs_online() {
        return is_online;
    }

    public void setIs_online(Boolean is_online) {
        this.is_online = is_online;
    }

    public Long getLast_time_online() {
        return last_time_online;
    }

    public void setLast_time_online(Long last_time_online) {
        this.last_time_online = last_time_online;
    }
}

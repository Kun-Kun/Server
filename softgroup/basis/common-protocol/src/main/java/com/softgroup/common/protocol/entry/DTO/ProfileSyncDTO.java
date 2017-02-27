package com.softgroup.common.protocol.entry.DTO;

/**
 * Created by user on 26.02.2017.
 */
public class ProfileSyncDTO {
    //ключ
    private	String	id;
    //дата изменения
    private	Long	last_modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Long last_modified) {
        this.last_modified = last_modified;
    }
}

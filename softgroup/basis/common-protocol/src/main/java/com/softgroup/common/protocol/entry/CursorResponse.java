package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class CursorResponse {
    //наличие данных ещё
    private	Boolean	is_more_exists;

    public Boolean getIs_more_exists() {
        return is_more_exists;
    }

    public void setIs_more_exists(Boolean is_more_exists) {
        this.is_more_exists = is_more_exists;
    }
}

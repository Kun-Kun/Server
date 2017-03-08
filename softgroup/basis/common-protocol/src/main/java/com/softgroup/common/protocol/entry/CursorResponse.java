package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class CursorResponse {
    //наличие данных ещё
    private	Boolean isMoreExists;

    public Boolean getIsMoreExists() {
        return isMoreExists;
    }

    public void setIsMoreExists(Boolean isMoreExists) {
        this.isMoreExists = isMoreExists;
    }
}

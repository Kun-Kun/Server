package com.softgroup.common.protocol.DTO;

/**
 * Created by user on 26.02.2017.
 */
public class DTOCursorResponse {
    //is any message exist to load
    private	Boolean isMoreExists;

    public Boolean getIsMoreExists() {
        return isMoreExists;
    }

    public void setIsMoreExists(Boolean isMoreExists) {
        this.isMoreExists = isMoreExists;
    }
}

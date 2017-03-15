package com.softgroup.common.protocol.DTO;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOCursorResponse implements Serializable {
    //is any message exist to load
    private	Boolean isMoreExists;

    public Boolean getIsMoreExists() {
        return isMoreExists;
    }

    public void setIsMoreExists(Boolean isMoreExists) {
        this.isMoreExists = isMoreExists;
    }
}

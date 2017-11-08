package com.softgroup.common.dto;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOCursorResponse implements Serializable {

    private static final long serialVersionUID = -3318824839331487492L;
    //is any message exist to load
    private	Boolean isMoreExists;

    public Boolean getIsMoreExists() {
        return isMoreExists;
    }

    public void setIsMoreExists(Boolean isMoreExists) {
        this.isMoreExists = isMoreExists;
    }
}

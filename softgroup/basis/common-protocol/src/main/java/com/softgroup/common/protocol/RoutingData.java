package com.softgroup.common.protocol;

import java.io.Serializable;

/**
 * Created by user on 05.04.2017.
 */
public class RoutingData implements Serializable{

    private static final long serialVersionUID = 1428472002610485493L;

    private String userId;
    private String deviceId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}

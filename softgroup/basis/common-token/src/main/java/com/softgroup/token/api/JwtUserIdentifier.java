package com.softgroup.token.api;



/**
 * Created by stephan on 20.03.16.
 */
public class JwtUserIdentifier  {

    private final String userId;
    private final String deviceId;

    public JwtUserIdentifier(String userId, String deviceId) {
        this.userId = userId;
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDeviceId() {
        return deviceId;
    }
}

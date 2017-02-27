package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 25.02.2017.
 */
public class SmsConfirmResponse implements ResponseData {
    private static final long serialVersionUID = 8952378677509681751L;

    private String deviceToken;

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}

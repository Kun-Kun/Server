package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetOtherProfilesRequest implements RequestData {

    private static final long serialVersionUID = 10420441880261540L;

    private List<String> userId;

    public List<String> getUserId() {
        return userId;
    }

    public void setUserId(List<String> userId) {
        this.userId = userId;
    }
}

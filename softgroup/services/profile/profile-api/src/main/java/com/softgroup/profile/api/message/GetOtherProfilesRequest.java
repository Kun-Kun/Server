package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetOtherProfilesRequest implements RequestData {

    private ArrayList<String> userId;

    public ArrayList<String> getUserId() {
        return userId;
    }

    public void setUserId(ArrayList<String> userId) {
        this.userId = userId;
    }
}

package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetOtherProfilesRequest implements RequestData {

    private ArrayList<String> user_id;

    public ArrayList<String> getUser_id() {
        return user_id;
    }

    public void setUser_id(ArrayList<String> user_id) {
        this.user_id = user_id;
    }
}

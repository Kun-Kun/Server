package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetLastTimeOnlineRequest implements RequestData {

    private ArrayList<String> profiles;

    public ArrayList<String> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<String> profiles) {
        this.profiles = profiles;
    }
}

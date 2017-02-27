package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.Profile;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetMyProfileResponse implements ResponseData {
    private ArrayList<Profile> profile;

    public ArrayList<Profile> getProfile() {
        return profile;
    }

    public void setProfile(ArrayList<Profile> profile) {
        this.profile = profile;
    }
}

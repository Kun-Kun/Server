package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.Profile;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetContactProfilesResponse implements ResponseData {

    private ArrayList<Profile> profiles;

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }
}

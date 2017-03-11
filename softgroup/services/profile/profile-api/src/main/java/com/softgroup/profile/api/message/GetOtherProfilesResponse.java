package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.DTO.DTOProfile;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetOtherProfilesResponse implements ResponseData {

    private ArrayList<DTOProfile> profiles;

    public ArrayList<DTOProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<DTOProfile> profiles) {
        this.profiles = profiles;
    }
}

package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.DTO.DTOProfile;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetMyProfileResponse implements ResponseData {
    private ArrayList<DTOProfile> profile;

    public ArrayList<DTOProfile> getProfile() {
        return profile;
    }

    public void setProfile(ArrayList<DTOProfile> profile) {
        this.profile = profile;
    }
}

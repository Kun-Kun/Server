package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.DTO.DTOProfile;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetMyProfileResponse implements ResponseData {

    private static final long serialVersionUID = 3465556264906202483L;

    private List<DTOProfile> profile;

    public List<DTOProfile> getProfile() {
        return profile;
    }

    public void setProfile(List<DTOProfile> profile) {
        this.profile = profile;
    }
}

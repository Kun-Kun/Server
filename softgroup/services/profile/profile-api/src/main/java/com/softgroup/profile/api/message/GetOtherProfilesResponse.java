package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.message.dto.DTOProfile;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetOtherProfilesResponse implements ResponseData {

    private static final long serialVersionUID = 795010381645511603L;

    private List<DTOProfile> profiles;

    public List<DTOProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<DTOProfile> profiles) {
        this.profiles = profiles;
    }
}

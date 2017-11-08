package com.softgroup.profile.api.message;

import com.softgroup.common.dto.DTOProfile;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetContactProfilesResponse implements ResponseData {

    private static final long serialVersionUID = -5622128439631121423L;

    private List<DTOProfile> profiles;

    public List<DTOProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<DTOProfile> profiles) {
        this.profiles = profiles;
    }
}

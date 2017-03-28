package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.message.dto.DTOProfile;

/**
 * Created by user on 26.02.2017.
 */
public class GetMyProfileResponse implements ResponseData {

    private static final long serialVersionUID = 3465556264906202483L;

    private DTOProfile profile;

    public DTOProfile getProfile() {
        return profile;
    }

    public void setProfile(DTOProfile profile) {
        this.profile = profile;
    }
}

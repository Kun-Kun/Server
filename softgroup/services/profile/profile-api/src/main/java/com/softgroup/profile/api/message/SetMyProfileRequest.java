package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.DTO.DTOProfile;

/**
 * Created by user on 26.02.2017.
 */
public class SetMyProfileRequest implements RequestData {

    private static final long serialVersionUID = 3197121374171124306L;

    private DTOProfile profile;

    public DTOProfile getProfile() {
        return profile;
    }

    public void setProfile(DTOProfile profile) {
        this.profile = profile;
    }
}

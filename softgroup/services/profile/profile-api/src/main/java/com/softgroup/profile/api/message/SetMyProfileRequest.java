package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.entry.Profile;

/**
 * Created by user on 26.02.2017.
 */
public class SetMyProfileRequest implements RequestData {
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

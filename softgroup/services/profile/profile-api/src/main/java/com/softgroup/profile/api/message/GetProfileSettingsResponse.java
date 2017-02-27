package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ProfileSettings;

/**
 * Created by user on 26.02.2017.
 */
public class GetProfileSettingsResponse implements ResponseData {

    private ProfileSettings settings;

    public ProfileSettings getSettings() {
        return settings;
    }

    public void setSettings(ProfileSettings settings) {
        this.settings = settings;
    }
}

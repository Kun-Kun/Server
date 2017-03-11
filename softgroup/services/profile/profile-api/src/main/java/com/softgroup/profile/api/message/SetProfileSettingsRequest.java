package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.DTO.DTOProfileSettings;

/**
 * Created by user on 26.02.2017.
 */
public class SetProfileSettingsRequest implements RequestData {

    private DTOProfileSettings settings;

    public DTOProfileSettings getSettings() {
        return settings;
    }

    public void setSettings(DTOProfileSettings settings) {
        this.settings = settings;
    }
}

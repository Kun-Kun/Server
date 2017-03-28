package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.message.dto.DTOProfileSettings;

/**
 * Created by user on 26.02.2017.
 */
public class SetProfileSettingsRequest implements RequestData {

    private static final long serialVersionUID = -5409999120966847151L;

    private DTOProfileSettings settings;

    public DTOProfileSettings getSettings() {
        return settings;
    }

    public void setSettings(DTOProfileSettings settings) {
        this.settings = settings;
    }
}

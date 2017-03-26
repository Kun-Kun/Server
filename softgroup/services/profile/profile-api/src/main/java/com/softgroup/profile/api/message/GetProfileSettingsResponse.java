package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.DTO.DTOProfileSettings;

/**
 * Created by user on 26.02.2017.
 */
public class GetProfileSettingsResponse implements ResponseData {

    private static final long serialVersionUID = 3892069631319913897L;

    private DTOProfileSettings settings;

    public DTOProfileSettings getSettings() {
        return settings;
    }

    public void setSettings(DTOProfileSettings settings) {
        this.settings = settings;
    }
}

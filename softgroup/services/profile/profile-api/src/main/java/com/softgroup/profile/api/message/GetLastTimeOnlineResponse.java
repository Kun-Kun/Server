package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.message.dto.DTOProfileStatus;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetLastTimeOnlineResponse  implements ResponseData {

    private static final long serialVersionUID = -1241805632783921307L;

    private List<DTOProfileStatus> profiles;

    public List<DTOProfileStatus> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<DTOProfileStatus> profiles) {
        this.profiles = profiles;
    }
}

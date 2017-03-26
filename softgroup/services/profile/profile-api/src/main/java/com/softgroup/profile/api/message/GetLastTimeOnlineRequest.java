package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetLastTimeOnlineRequest implements RequestData {

    private static final long serialVersionUID = -7870505028886863516L;

    private List<String> profiles;

    public List<String> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<String> profiles) {
        this.profiles = profiles;
    }
}

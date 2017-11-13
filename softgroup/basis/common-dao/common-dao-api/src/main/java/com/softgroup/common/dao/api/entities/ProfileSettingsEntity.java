package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "profile_settings")
public class ProfileSettingsEntity extends BaseEntity {

    private static final long serialVersionUID = 4649233715071591523L;

    @Column(name = "profile_id",unique = true)
    private String profileId;

    @Column(name = "setting")
    private String setting;


    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileSettingsEntity)) return false;

        ProfileSettingsEntity that = (ProfileSettingsEntity) o;

        if (getProfileId() != null ? !getProfileId().equals(that.getProfileId()) : that.getProfileId() != null)
            return false;
        return getSetting() != null ? getSetting().equals(that.getSetting()) : that.getSetting() == null;
    }

    @Override
    public int hashCode() {
        int result = getProfileId() != null ? getProfileId().hashCode() : 0;
        result = 31 * result + (getSetting() != null ? getSetting().hashCode() : 0);
        return result;
    }
}

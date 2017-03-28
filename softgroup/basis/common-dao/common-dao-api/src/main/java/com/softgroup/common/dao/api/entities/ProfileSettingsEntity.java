package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@PrimaryKeyJoinColumn
@Table(name = "profile_settings")
public class ProfileSettingsEntity extends BaseEntity {

    private static final long serialVersionUID = 4649233715071591523L;

    @Column(name = "profile_id",unique = true)
    private String profileId;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileSettingsEntity that = (ProfileSettingsEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getProfileId() != null ? getProfileId().equals(that.getProfileId()) : that.getProfileId() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getProfileId() != null ? getProfileId().hashCode() : 0);
        return result;
    }
}

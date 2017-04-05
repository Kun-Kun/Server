package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

/**
 * Created by Odin on 29.02.2016.
 */
@Entity
@Table(name = "profiles")
public class ProfileEntity extends BaseEntity{

    private static final long serialVersionUID = 2645460488213358603L;

	@Column(name = "phone_number",unique = true)
    private String phoneNumber;

	@Column(name = "create_date_time")
    private Long createDateTime;

	@Column(name = "update_date_time")
	private Long updateDateTime;

	@Column(name = "name")
    private String name;

	@Column(name = "status")
    private String status;

	@Column(name = "avatar_uri")
    private String avatarUri;

    @Column(name = "last_time_online")
    private Long lastTimeOnline;

    @Column(name = "locale")
    private String locale;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

	public Long getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Long updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public Long getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Long lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileEntity that = (ProfileEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() != null)
            return false;
        if (getCreateDateTime() != null ? !getCreateDateTime().equals(that.getCreateDateTime()) : that.getCreateDateTime() != null)
            return false;
        if (getUpdateDateTime() != null ? !getUpdateDateTime().equals(that.getUpdateDateTime()) : that.getUpdateDateTime() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getAvatarUri() != null ? !getAvatarUri().equals(that.getAvatarUri()) : that.getAvatarUri() != null)
            return false;
        if (getLastTimeOnline() != null ? !getLastTimeOnline().equals(that.getLastTimeOnline()) : that.getLastTimeOnline() != null)
            return false;
        return getLocale() != null ? getLocale().equals(that.getLocale()) : that.getLocale() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getCreateDateTime() != null ? getCreateDateTime().hashCode() : 0);
        result = 31 * result + (getUpdateDateTime() != null ? getUpdateDateTime().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getAvatarUri() != null ? getAvatarUri().hashCode() : 0);
        result = 31 * result + (getLastTimeOnline() != null ? getLastTimeOnline().hashCode() : 0);
        result = 31 * result + (getLocale() != null ? getLocale().hashCode() : 0);
        return result;
    }
}
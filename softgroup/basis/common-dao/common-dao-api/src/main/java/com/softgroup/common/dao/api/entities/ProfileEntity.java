package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Odin on 29.02.2016.
 */
@Entity
@Table(name = "profiles")
public class ProfileEntity implements Serializable{

    private static final long serialVersionUID = 2645460488213358603L;

    @Id
    @Column(name = "id")
    private String id;

	@Column(name = "phone_number")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileEntity that = (ProfileEntity) o;

        if (!id.equals(that.id)) return false;
        if (!phoneNumber.equals(that.phoneNumber)) return false;
        if (!createDateTime.equals(that.createDateTime)) return false;
        if (!updateDateTime.equals(that.updateDateTime)) return false;
        if (!name.equals(that.name)) return false;
        if (!status.equals(that.status)) return false;
        return avatarUri.equals(that.avatarUri);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + createDateTime.hashCode();
        result = 31 * result + updateDateTime.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + avatarUri.hashCode();
        return result;
    }
}
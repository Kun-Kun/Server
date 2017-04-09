package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

import com.softgroup.common.protocol.enumeration.ConversationType;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "conversations")
public class ConversationEntity extends BaseEntity {

    private static final long serialVersionUID = -8700529675793334330L;

    @Column(name = "name")
    private String name;

    @Column(name = "logo_image_uri")
    private String logoImageUri;

    @Column(name = "type")
    private ConversationType type;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "is_exists")
    private Boolean exists;

    @Column(name = "create_time")
    private Long createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationEntity that = (ConversationEntity) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getLogoImageUri() != null ? !getLogoImageUri().equals(that.getLogoImageUri()) : that.getLogoImageUri() != null)
            return false;
        if (getType() != that.getType()) return false;
        if (getAdminId() != null ? !getAdminId().equals(that.getAdminId()) : that.getAdminId() != null) return false;
        if (getExists() != null ? !getExists().equals(that.getExists()) : that.getExists() != null) return false;
        return getCreateTime() != null ? getCreateTime().equals(that.getCreateTime()) : that.getCreateTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getLogoImageUri() != null ? getLogoImageUri().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getAdminId() != null ? getAdminId().hashCode() : 0);
        result = 31 * result + (getExists() != null ? getExists().hashCode() : 0);
        result = 31 * result + (getCreateTime() != null ? getCreateTime().hashCode() : 0);
        return result;
    }
}

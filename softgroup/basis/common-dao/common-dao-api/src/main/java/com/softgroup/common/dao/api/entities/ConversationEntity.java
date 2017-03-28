package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "conversations")
public class ConversationEntity extends BaseEntity {

    private static final long serialVersionUID = -8700529675793334330L;

    @Column(name = "name")
    private String name;

    @Column(name = "logo_immage_uri")
    private String logoImageUri;

    @Column(name = "type")
    private ConversationType type;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "exists")
    private Boolean exists;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationEntity that = (ConversationEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getLogoImageUri() != null ? !getLogoImageUri().equals(that.getLogoImageUri()) : that.getLogoImageUri() != null)
            return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        if (getAdminId() != null ? !getAdminId().equals(that.getAdminId()) : that.getAdminId() != null) return false;
        return getExists() != null ? getExists().equals(that.getExists()) : that.getExists() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getLogoImageUri() != null ? getLogoImageUri().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getAdminId() != null ? getAdminId().hashCode() : 0);
        result = 31 * result + (getExists() != null ? getExists().hashCode() : 0);
        return result;
    }
}

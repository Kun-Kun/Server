package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "contacts")
public class ContactEntity extends BaseEntity{

    private static final long serialVersionUID = -9200905802959489917L;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "name")
    private String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactEntity)) return false;

        ContactEntity that = (ContactEntity) o;

        if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId() != null ? getUserId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}

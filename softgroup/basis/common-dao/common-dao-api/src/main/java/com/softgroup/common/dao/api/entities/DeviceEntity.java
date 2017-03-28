package com.softgroup.common.dao.api.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@PrimaryKeyJoinColumn
@Table(name = "devices")
public class DeviceEntity extends BaseEntity{
    private static final long serialVersionUID = -506229924089552354L;


    @Column(name = "device_id",unique = true)
    private String deviceId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "last_confirm")
    private Long lastConfirm;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLastConfirm() {
        return lastConfirm;
    }

    public void setLastConfirm(Long lastConfirm) {
        this.lastConfirm = lastConfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceEntity that = (DeviceEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getDeviceId() != null ? !getDeviceId().equals(that.getDeviceId()) : that.getDeviceId() != null)
            return false;
        if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
        return getLastConfirm() != null ? getLastConfirm().equals(that.getLastConfirm()) : that.getLastConfirm() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDeviceId() != null ? getDeviceId().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getLastConfirm() != null ? getLastConfirm().hashCode() : 0);
        return result;
    }
}

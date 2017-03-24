package com.softgroup.common.dao.api.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "devices")
public class DeviceEntity implements Serializable{
    private static final long serialVersionUID = -506229924089552354L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "device_id",unique = true)
    private String deviceId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "last_confirm")
    private Long lastConfirm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}

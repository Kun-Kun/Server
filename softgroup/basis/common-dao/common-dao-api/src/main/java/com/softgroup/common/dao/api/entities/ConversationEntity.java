package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "conversations")
public class ConversationEntity implements Serializable {
    private static final long serialVersionUID = -8700529675793334330L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo_immage_uri")
    private String logoImageUri;

    @Column(name = "type")
    private Integer type;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "exists")
    private Boolean exists;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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
}

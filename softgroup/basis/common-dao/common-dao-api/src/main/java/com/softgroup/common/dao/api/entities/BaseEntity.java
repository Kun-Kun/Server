package com.softgroup.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

/**
 * Created by user on 27.03.2017.
 */
@MappedSuperclass
@Inheritance(strategy=SINGLE_TABLE)
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = -7623698971499767165L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

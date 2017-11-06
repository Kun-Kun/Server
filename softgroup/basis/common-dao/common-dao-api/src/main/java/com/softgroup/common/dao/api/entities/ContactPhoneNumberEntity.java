package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "contact_phone_numbers")
public class ContactPhoneNumberEntity extends BaseEntity{

    private static final long serialVersionUID = -9200905802959489917L;

    @Column(name = "contact_id")
    private String contactId;

    @Column(name = "phone_number")
    private String phoneNumber;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactPhoneNumberEntity)) return false;

        ContactPhoneNumberEntity that = (ContactPhoneNumberEntity) o;

        if (getContactId() != null ? !getContactId().equals(that.getContactId()) : that.getContactId() != null)
            return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getContactId() != null ? getContactId().hashCode() : 0;
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }
}

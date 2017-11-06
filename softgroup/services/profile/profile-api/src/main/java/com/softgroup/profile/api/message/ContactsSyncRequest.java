package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.message.dto.DTOContact;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class ContactsSyncRequest implements RequestData {

    private static final long serialVersionUID = -3715762483500076459L;

    private List<DTOContact> addedContact;

    private List<DTOContact> removedContact;

    public List<DTOContact> getAddedContact() {
        return addedContact;
    }

    public void setAddedContact(List<DTOContact> addedContact) {
        this.addedContact = addedContact;
    }

    public List<DTOContact> getRemovedContact() {
        return removedContact;
    }

    public void setRemovedContact(List<DTOContact> removedContact) {
        this.removedContact = removedContact;
    }
}

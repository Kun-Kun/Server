package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.DTO.DTOContact;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class ContactsSyncRequest implements RequestData {

    private static final long serialVersionUID = -3715762483500076459L;

    private List<DTOContact> addedContact;

    public List<DTOContact> getAddedContact() {
        return addedContact;
    }

    public void setAddedContact(List<DTOContact> addedConatct) {
        this.addedContact = addedContact;
    }
}

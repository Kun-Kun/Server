package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.DTO.DTOContact;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class ContactsSyncRequest implements RequestData {
    private ArrayList<DTOContact> addedContact;

    public ArrayList<DTOContact> getAddedContact() {
        return addedContact;
    }

    public void setAddedContact(ArrayList<DTOContact> addedConatct) {
        this.addedContact = addedContact;
    }
}

package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.entry.Contact;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class ContactsSyncRequest implements RequestData {
    private ArrayList<Contact> addedContact;

    public ArrayList<Contact> getAddedContact() {
        return addedContact;
    }

    public void setAddedContact(ArrayList<Contact> addedConatct) {
        this.addedContact = addedContact;
    }
}

package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.entry.Contact;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class ContactsSyncRequest implements RequestData {
    private ArrayList<Contact> added_contct;

    public ArrayList<Contact> getAdded_contct() {
        return added_contct;
    }

    public void setAdded_contct(ArrayList<Contact> added_contct) {
        this.added_contct = added_contct;
    }
}

package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class CreateConversationRequest implements RequestData {
    private int type;
    private ArrayList<String> members_ids;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<String> getMembers_ids() {
        return members_ids;
    }

    public void setMembers_ids(ArrayList<String> members_ids) {
        this.members_ids = members_ids;
    }
}

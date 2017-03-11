package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class CreateConversationRequest implements RequestData {

    private int type;

    private ArrayList<String> membersIds;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<String> getMembersIds() {
        return membersIds;
    }

    public void setMembersIds(ArrayList<String> membersIds) {
        this.membersIds = membersIds;
    }
}

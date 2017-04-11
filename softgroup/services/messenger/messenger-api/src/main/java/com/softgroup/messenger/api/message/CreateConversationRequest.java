package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.enumeration.ConversationType;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class CreateConversationRequest implements RequestData {

    private static final long serialVersionUID = 1822049685804584140L;

    private ConversationType type;

    private List<String> membersIds;

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }

    public List<String> getMembersIds() {
        return membersIds;
    }

    public void setMembersIds(List<String> membersIds) {
        this.membersIds = membersIds;
    }
}

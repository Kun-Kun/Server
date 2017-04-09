package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.enumeration.ConversationType;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsRequest implements RequestData {

    private static final long serialVersionUID = 5665011706856076016L;

    private ConversationType type;

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }
}

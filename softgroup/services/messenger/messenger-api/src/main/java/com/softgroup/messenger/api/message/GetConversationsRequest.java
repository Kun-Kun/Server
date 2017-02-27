package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsRequest implements RequestData {
    /*
        * "type:
        0-индивидуальный
        1-групповой
        если не указан — тогда все"
        */
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

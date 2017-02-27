package com.softgroup.common.protocol.entry.DTO;

/**
 * Created by user on 26.02.2017.
 */
public class ConversationSyncDTO {
    //id конверсейшна
    private String	id;
    //индекс последнего сообщения на клиенте
    private String	last_message_index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast_message_index() {
        return last_message_index;
    }

    public void setLast_message_index(String last_message_index) {
        this.last_message_index = last_message_index;
    }

}

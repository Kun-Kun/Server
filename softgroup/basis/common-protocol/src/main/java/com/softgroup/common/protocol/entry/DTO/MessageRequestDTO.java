package com.softgroup.common.protocol.entry.DTO;

/**
 * Created by user on 26.02.2017.
 */
public class MessageRequestDTO {
    //id Conversation
    private	String conversation_id;
    //Тип сообщения
    private	Integer message_type;
    //текст сообщения
    private	String payload;
    //создание на клиенте
    private	Long create_time;

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public Integer getMessage_type() {
        return message_type;
    }

    public void setMessage_type(Integer message_type) {
        this.message_type = message_type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }
}

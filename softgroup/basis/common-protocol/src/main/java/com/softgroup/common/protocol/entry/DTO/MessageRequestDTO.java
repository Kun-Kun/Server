package com.softgroup.common.protocol.entry.DTO;

/**
 * Created by user on 26.02.2017.
 */
public class MessageRequestDTO {
    //id Conversation
    private	String conversationId;
    //Тип сообщения
    private	Integer messageType;
    //текст сообщения
    private	String payload;
    //создание на клиенте
    private	Long createTime;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}

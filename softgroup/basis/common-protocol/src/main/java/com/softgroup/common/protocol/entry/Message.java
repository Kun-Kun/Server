package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class Message {
    //ключ
    private String id;
    //id отправителя
    private String senderId;
    //id Conversation
    private String conversationId;
    //Тип сообщения
    private Integer messageType;
    //текст сообщения
    private String payload;
    //состояние (выдаётся сервером)
    private Integer status;
    //создание на клиенте
    private Long createTime;
    //время получения сервером
    private Long serverReceiveTime;
    //индекс сообщения
    private Long messageIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getServerReceiveTime() {
        return serverReceiveTime;
    }

    public void setServerReceiveTime(Long serverReceiveTime) {
        this.serverReceiveTime = serverReceiveTime;
    }

    public Long getMessageIndex() {
        return messageIndex;
    }

    public void setMessageIndex(Long messageIndex) {
        this.messageIndex = messageIndex;
    }
}

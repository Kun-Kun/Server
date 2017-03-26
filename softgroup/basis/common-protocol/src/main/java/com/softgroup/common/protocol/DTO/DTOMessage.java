package com.softgroup.common.protocol.DTO;

import com.softgroup.common.protocol.DTO.enumeration.MessageStatus;
import com.softgroup.common.protocol.DTO.enumeration.MessageType;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOMessage implements Serializable {

    private static final long serialVersionUID = 6425236962275442227L;
    //key
    private String id;
    //sender id
    private String senderId;
    //id Conversation
    private String conversationId;
    //message type
    private MessageType messageType;
    //message text
    private String payload;
    //message status
    private MessageStatus status;
    //create time generated by user
    private Long createTime;
    //server receive time
    private Long serverReceiveTime;
    //message index
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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
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

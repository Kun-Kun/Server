package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "messages")
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = -6779438608811972046L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "message_type")
    private Integer messageType;

    @Column(name = "payload")
    private String payload;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "server_receive_time")
    private Long serverReceiveTime;

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
}

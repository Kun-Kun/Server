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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getSenderId() != null ? !getSenderId().equals(that.getSenderId()) : that.getSenderId() != null)
            return false;
        if (getConversationId() != null ? !getConversationId().equals(that.getConversationId()) : that.getConversationId() != null)
            return false;
        if (getMessageType() != null ? !getMessageType().equals(that.getMessageType()) : that.getMessageType() != null)
            return false;
        if (getPayload() != null ? !getPayload().equals(that.getPayload()) : that.getPayload() != null) return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        if (getCreateTime() != null ? !getCreateTime().equals(that.getCreateTime()) : that.getCreateTime() != null)
            return false;
        return getServerReceiveTime() != null ? getServerReceiveTime().equals(that.getServerReceiveTime()) : that.getServerReceiveTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSenderId() != null ? getSenderId().hashCode() : 0);
        result = 31 * result + (getConversationId() != null ? getConversationId().hashCode() : 0);
        result = 31 * result + (getMessageType() != null ? getMessageType().hashCode() : 0);
        result = 31 * result + (getPayload() != null ? getPayload().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getCreateTime() != null ? getCreateTime().hashCode() : 0);
        result = 31 * result + (getServerReceiveTime() != null ? getServerReceiveTime().hashCode() : 0);
        return result;
    }
}

package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

import com.softgroup.common.protocol.enumeration.MessageStatus;

/**
 * Created by user on 03.04.2017.
 */
@Entity
@Table(name = "message_status")
public class MessageStatusEntity extends BaseEntity{

    private static final long serialVersionUID = 4025707938346756940L;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "status")
    private MessageStatus status;

    @Column(name = "status_date")
    private Long statusDate;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public Long getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Long statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageStatusEntity that = (MessageStatusEntity) o;

        if (getMessageId() != null ? !getMessageId().equals(that.getMessageId()) : that.getMessageId() != null)
            return false;
        if (getSenderId() != null ? !getSenderId().equals(that.getSenderId()) : that.getSenderId() != null)
            return false;
        if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
        if (getStatus() != null ? !getStatus().equals(that.getStatus()) : that.getStatus() != null) return false;
        return getStatusDate() != null ? getStatusDate().equals(that.getStatusDate()) : that.getStatusDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getMessageId() != null ? getMessageId().hashCode() : 0;
        result = 31 * result + (getSenderId() != null ? getSenderId().hashCode() : 0);
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getStatusDate() != null ? getStatusDate().hashCode() : 0);
        return result;
    }
}

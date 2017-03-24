package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "conversation_member_list")
public class ConversationMemberListEntity implements Serializable{
    private static final long serialVersionUID = -2537713759067626591L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "last_read_message_id")
    private String lastReadMessageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getLastReadMessageId() {
        return lastReadMessageId;
    }

    public void setLastReadMessageId(String lastReadMessageId) {
        this.lastReadMessageId = lastReadMessageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationMemberListEntity that = (ConversationMemberListEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getConversationId() != null ? !getConversationId().equals(that.getConversationId()) : that.getConversationId() != null)
            return false;
        if (getMemberId() != null ? !getMemberId().equals(that.getMemberId()) : that.getMemberId() != null)
            return false;
        return getLastReadMessageId() != null ? getLastReadMessageId().equals(that.getLastReadMessageId()) : that.getLastReadMessageId() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getConversationId() != null ? getConversationId().hashCode() : 0);
        result = 31 * result + (getMemberId() != null ? getMemberId().hashCode() : 0);
        result = 31 * result + (getLastReadMessageId() != null ? getLastReadMessageId().hashCode() : 0);
        return result;
    }
}

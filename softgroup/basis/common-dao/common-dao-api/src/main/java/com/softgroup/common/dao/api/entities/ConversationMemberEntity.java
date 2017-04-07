package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

/**
 * Created by user on 24.03.2017.
 */
@Entity
@Table(name = "conversation_members")
public class ConversationMemberEntity extends BaseEntity{
    private static final long serialVersionUID = -2537713759067626591L;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "last_message_id")
    private String lastMessageId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "join_date")
    private Long joinDate;

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

    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Long joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationMemberEntity that = (ConversationMemberEntity) o;

        if (getConversationId() != null ? !getConversationId().equals(that.getConversationId()) : that.getConversationId() != null)
            return false;
        if (getMemberId() != null ? !getMemberId().equals(that.getMemberId()) : that.getMemberId() != null)
            return false;
        if (getLastMessageId() != null ? !getLastMessageId().equals(that.getLastMessageId()) : that.getLastMessageId() != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return getJoinDate() != null ? getJoinDate().equals(that.getJoinDate()) : that.getJoinDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getConversationId() != null ? getConversationId().hashCode() : 0;
        result = 31 * result + (getMemberId() != null ? getMemberId().hashCode() : 0);
        result = 31 * result + (getLastMessageId() != null ? getLastMessageId().hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (getJoinDate() != null ? getJoinDate().hashCode() : 0);
        return result;
    }
}
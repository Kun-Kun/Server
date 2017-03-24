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
}

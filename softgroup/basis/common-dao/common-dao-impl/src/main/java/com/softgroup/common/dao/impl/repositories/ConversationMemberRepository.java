package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface ConversationMemberRepository extends PagingAndSortingRepository<ConversationMemberEntity, String> {

    List<ConversationMemberEntity> findByMemberId(String memberId);

    List<ConversationMemberEntity> findByConversationId(String conversationId);

    List<ConversationMemberEntity> findByConversationIdAndMemberId(String conversationId, String memberId);

}

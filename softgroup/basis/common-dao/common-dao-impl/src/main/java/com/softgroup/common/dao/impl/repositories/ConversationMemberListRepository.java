package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationMemberListEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface ConversationMemberListRepository extends PagingAndSortingRepository<ConversationMemberListEntity, String> {

    ConversationMemberListEntity findById(String id);

    List<ConversationMemberListEntity> findByMemberId(String memberId);

    List<ConversationMemberListEntity> findByConversationId(String conversationId);

    List<ConversationMemberListEntity> findByConversationIdAndMemberId(String conversationId,String memberId);

}

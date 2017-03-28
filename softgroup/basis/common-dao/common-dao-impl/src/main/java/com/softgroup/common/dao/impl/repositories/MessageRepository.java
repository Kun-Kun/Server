package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.MessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface MessageRepository extends PagingAndSortingRepository<MessageEntity, String> {

    List<MessageEntity> findBySenderIdAndConversationId(String senderId, String conversationId);
}

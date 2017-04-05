package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.MessageStatusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.softgroup.messenger.api.dto.enumeration.*;

import java.util.List;

/**
 * Created by user on 03.04.2017.
 */
public interface MessageStatusRepository extends PagingAndSortingRepository<MessageStatusEntity, String> {

    List<MessageStatusEntity> findByMessageId(String messageId);

    List<MessageStatusEntity> findByUserIdAndMessageId(String userId, String messageId);

    List<MessageStatusEntity> findByUserIdAndStatus(String userId, MessageStatus status);

}


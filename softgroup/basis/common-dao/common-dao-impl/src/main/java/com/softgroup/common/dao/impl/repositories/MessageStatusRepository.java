package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.MessageStatusEntity;
import com.softgroup.common.protocol.enumeration.MessageStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 03.04.2017.
 */
public interface MessageStatusRepository extends PagingAndSortingRepository<MessageStatusEntity, String> {

    List<MessageStatusEntity> findByMessageId(String messageId);

    List<MessageStatusEntity> findByUserIdAndMessageId(String userId, String messageId);

    List<MessageStatusEntity> findByUserIdAndStatus(String userId, MessageStatus status);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =  "UPDATE messenger.message_status ms SET ms.status_date = IF(ms.status = 1,UNIX_TIMESTAMP(NOW()),ms.status_date), ms.status=IF(ms.status=1,2,ms.status) WHERE ms.id IN (SELECT * FROM (SELECT ms.id FROM messenger.messages m LEFT JOIN messenger.message_status ms ON m.id = ms.message_id WHERE m.server_receive_time < :serverReceiveTime AND ms.user_id= :userId AND m.conversation_id = :conversationId AND ms.status !=4 ORDER BY m.server_receive_time DESC LIMIT :limit) AS t)")
    void markMessageStatusAsDelivered(@Param(value = "conversationId") String conversationId, @Param(value = "userId") String userId, @Param(value = "serverReceiveTime") Long serverReceiveTime, @Param(value = "limit") Integer limit);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value =  "UPDATE message_status ms LEFT JOIN messages m ON m.id = ms.message_id SET ms.status = 3, ms.status_date = UNIX_TIMESTAMP(NOW()) WHERE ms.user_id = :userId AND m.conversation_id = :conversationId AND ms.status = 2 AND ms.message_id in :messageIds")
    void markMessageStatusAsViewed(@Param(value = "conversationId") String conversationId, @Param(value = "userId") String userId, @Param(value = "messageIds") List<String> messageIds);
}


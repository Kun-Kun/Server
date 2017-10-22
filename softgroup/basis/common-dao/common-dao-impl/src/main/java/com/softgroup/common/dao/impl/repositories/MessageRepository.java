package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.MessageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface MessageRepository extends PagingAndSortingRepository<MessageEntity, String> {

    List<MessageEntity> findBySenderIdAndConversationId(String senderId, String conversationId);

    @Query(nativeQuery = true, value =  "SELECT * FROM messages m LEFT JOIN message_status ms ON m.id = ms.message_id WHERE m.conversation_id = :conversationId AND ms.user_id  = :userId AND m.server_receive_time < :serverReceiveTime AND ms.status != 4 ORDER BY m.server_receive_time DESC LIMIT :limit")
    List<MessageEntity> findByConversationIdAndUserIdAndServerReceiveTimeBeforeLimit(@Param(value = "conversationId") String conversationId, @Param(value = "userId") String userId, @Param(value = "serverReceiveTime") Long serverReceiveTime, @Param(value = "limit") Integer limit);

    @Query(nativeQuery = true, value =  "SELECT count(*) FROM messages m LEFT JOIN message_status ms ON m.id = ms.message_id WHERE ms.user_id=:userId AND m.conversation_id =:conversationId AND ms.status in (1,2)")
    Integer getTotalUnreadMessages(@Param(value = "conversationId") String conversationId, @Param(value = "userId") String userId);
}

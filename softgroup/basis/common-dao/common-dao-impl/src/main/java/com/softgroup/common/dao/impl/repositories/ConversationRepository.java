package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.enumeration.ConversationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface ConversationRepository extends PagingAndSortingRepository<ConversationEntity, String> {

    List<ConversationEntity> findByName(String name);

    List<ConversationEntity> findByAdminId(String adminId);

    List<ConversationEntity> findByType(ConversationType type);

    //ToDo Make test with speed query of * and need columns in SELECT
    @Query(nativeQuery = true, value =  "SELECT *,COUNT(*) as q_member_size " +
                                            "FROM conversation_members cm " +
                                            "LEFT JOIN conversations c ON c.id = cm.conversation_id " +
                                            "WHERE cm.member_id in :memberIds and members_count=:#{#memberIds.size()} " +
                                            "GROUP BY conversation_id " +
                                            "HAVING q_member_size=members_count")
    ConversationEntity findOneByMemberIds(@Param(value = "memberIds") List<String> memberIds);

}

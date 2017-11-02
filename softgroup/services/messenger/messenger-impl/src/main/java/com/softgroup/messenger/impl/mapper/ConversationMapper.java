package com.softgroup.messenger.impl.mapper;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.messenger.api.dto.DTOConversation;
import org.mapstruct.Mapper;

/**
 * Created by user on 18.08.2017.
 */
@Mapper(componentModel="spring")
public interface ConversationMapper {

    DTOConversation mapConversationDtoFromEntity(ConversationEntity conversationEntity);

}

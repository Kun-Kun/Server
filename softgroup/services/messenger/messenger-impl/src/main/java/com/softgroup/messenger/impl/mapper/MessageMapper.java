package com.softgroup.messenger.impl.mapper;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.messenger.api.dto.DTOConversation;
import com.softgroup.messenger.api.dto.DTOMessage;
import com.softgroup.messenger.api.dto.DTOMessageRequest;
import org.mapstruct.Mapper;

/**
 * Created by user on 18.08.2017.
 */
@Mapper(componentModel="spring")
public interface MessageMapper {

    DTOMessage mapMessageDtoFromEntity(MessageEntity messageEntity);

    MessageEntity mapEntityFromMessageDto(DTOMessageRequest dtoMessage);

}

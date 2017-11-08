package com.softgroup.common.mapper;


import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.dto.DTOMessage;
import com.softgroup.common.dto.DTOMessageRequest;
import org.mapstruct.Mapper;

/**
 * Created by user on 18.08.2017.
 */
@Mapper(componentModel="spring")
public interface MessageMapper {

    DTOMessage mapMessageDtoFromEntity(MessageEntity messageEntity);

    MessageEntity mapEntityFromMessageDto(DTOMessageRequest dtoMessage);

}

package com.softgroup.messenger.impl.mapper;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.messenger.api.dto.DTOProfile;
import org.mapstruct.Mapper;

/**
 * Created by user on 18.08.2017.
 */
@Mapper(componentModel="spring")
public interface ProfileMapper {

    DTOProfile mapProfileDtoFromEntity(ProfileEntity conversationEntity);

}

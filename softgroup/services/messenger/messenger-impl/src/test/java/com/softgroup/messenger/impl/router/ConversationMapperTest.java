package com.softgroup.messenger.impl.router;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dto.DTOConversation;
import com.softgroup.common.mapper.ConversationMapper;
import com.softgroup.common.protocol.enumeration.ConversationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 18.08.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ConversationMapperTest {


    ConversationMapper mapper = Mappers.getMapper(ConversationMapper.class);

    private ConversationEntity entity = new ConversationEntity();

    @Before
    public void prepareEntity(){
        entity.setLogoImageUri("image");
        entity.setCreateTime(1234567L);
        entity.setMembersCount(2);
        entity.setExists(true);
        entity.setType(ConversationType.INDIVIDUAL);
        entity.setAdminId("1");
        entity.setName("Test");
        entity.setId("1");
    }

    @Test
    public void mapTest(){
        DTOConversation conversation = mapper.mapConversationDtoFromEntity(entity);
        assertThat(conversation.getId(), is("1"));
        assertThat(conversation.getLastMessageIndex(), nullValue());
        assertThat(conversation.getName(), is("Test"));
        assertThat(conversation.getType(), is(ConversationType.INDIVIDUAL));
        assertThat(conversation.getLogoImageUri(), is("image"));
    }
}

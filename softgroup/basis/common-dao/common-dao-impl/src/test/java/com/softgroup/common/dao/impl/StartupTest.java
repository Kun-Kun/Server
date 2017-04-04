package com.softgroup.common.dao.impl;

import com.softgroup.common.dao.api.entities.*;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.dao.impl.repositories.*;
import com.softgroup.messenger.api.dto.enumeration.ConversationType;
import com.softgroup.messenger.api.dto.enumeration.MessageStatus;
import com.softgroup.messenger.api.dto.enumeration.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Created by Odin on 04.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class StartupTest {

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ConversationMemberRepository conversationMemberRepository;
    @Autowired
    private ConversationRepository conversationRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageStatusRepository messageStatusRepository;
    @Autowired
    private ProfileSettingsRepository profileSettingsRepository;

    @Test
    public void profileEntityReadWriteTest(){
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName("test_name");
        profileEntity.setAvatarUri("uri");
        profileEntity.setCreateDateTime(123141241L);
        profileEntity.setLastTimeOnline(134123516L);
        profileEntity.setLocale("ua_ua");
        profileEntity.setPhoneNumber("1234568");
        profileEntity.setUpdateDateTime(2342342362L);

        profileEntity = profileRepository.save(profileEntity);

        ProfileEntity profile = profileRepository.findOne(profileEntity.getId());

        assertEquals(profileEntity,profile);

        List<ProfileEntity> profileEntities = profileRepository.findByName("test_name");
        assertThat(profileEntities.isEmpty(),is(false));

        profileRepository.delete(profileEntity.getId());

        profile = profileRepository.findOne(profileEntity.getId());

        assertNull(profile);

    }

    @Test
    public void contactEntityReadWriteTest(){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setName("test_name");
        contactEntity.setUserId("user_id");
        contactEntity.setPhoneNumber("12345678");

        contactEntity = contactRepository.save(contactEntity);

        ContactEntity contact = contactRepository.findOne(contactEntity.getId());

        assertEquals(contactEntity,contact);

        List<ContactEntity> contactEntities = contactRepository.findByUserId("user_id");
        assertThat(contactEntities.isEmpty(),is(false));

        contactRepository.delete(contactEntity.getId());

        contact = contactRepository.findOne(contactEntity.getId());

        assertNull(contact);

    }

    @Test
    public void conversationMemberEntityReadWriteTest(){
        ConversationMemberEntity conversationMember = new ConversationMemberEntity();
        conversationMember.setConversationId("conv_id");
        conversationMember.setMemberId("user_id");
        conversationMember.setLastMessageId("12345678");
        conversationMember.setDeleted(false);
        conversationMember.setJoinDate(123456124356L);

        conversationMember = conversationMemberRepository.save(conversationMember);

        ConversationMemberEntity member = conversationMemberRepository.findOne(conversationMember.getId());

        assertEquals(conversationMember,member);

        List<ConversationMemberEntity> conversationMemberEntities = conversationMemberRepository.findByConversationId("conv_id");
        assertThat(conversationMemberEntities.isEmpty(),is(false));

        conversationMemberRepository.delete(conversationMember.getId());

        member = conversationMemberRepository.findOne(conversationMember.getId());

        assertNull(member);

    }

    @Test
    public void conversationEntityReadWriteTest(){
        ConversationEntity conversation = new ConversationEntity();
        conversation.setName("name");
        conversation.setAdminId("user_id");
        conversation.setExists(true);
        conversation.setLogoImageUri("uri");
        conversation.setCreateTime(123456124356L);
        conversation.setType(ConversationType.GROUP);

        conversation = conversationRepository.save(conversation);

        ConversationEntity member = conversationRepository.findOne(conversation.getId());

        assertEquals(conversation,member);

        List<ConversationEntity> conversationEntities = conversationRepository.findByName("name");
        assertThat(conversationEntities.isEmpty(),is(false));

        conversationRepository.delete(conversation.getId());

        member = conversationRepository.findOne(conversation.getId());

        assertNull(member);

    }

    @Test
    public void deviceEntityReadWriteTest(){
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setDeviceId("dev_id");
        deviceEntity.setUserId("user_id");
        deviceEntity.setLastConfirm(123456124356L);

        deviceEntity = deviceRepository.save(deviceEntity);

        DeviceEntity device = deviceRepository.findOne(deviceEntity.getId());

        assertEquals(deviceEntity,device);

        List<DeviceEntity> deviceEntities = deviceRepository.findByUserId("user_id");
        assertThat(deviceEntities.isEmpty(),is(false));

        deviceRepository.delete(deviceEntity.getId());

        device = deviceRepository.findOne(deviceEntity.getId());

        assertNull(device);
    }

    @Test
    public void messageEntityReadWriteTest(){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setSenderId("sender_id");
        messageEntity.setConversationId("conv_id");
        messageEntity.setCreateTime(123456124356L);
        messageEntity.setServerReceiveTime(123456124356L);
        messageEntity.setPayload("payload");
        messageEntity.setMessageType(MessageType.TEXT);

        messageEntity = messageRepository.save(messageEntity);

        MessageEntity message = messageRepository.findOne(messageEntity.getId());

        assertEquals(messageEntity,message);

        List<MessageEntity> messageEntities = messageRepository.findBySenderIdAndConversationId("sender_id","conv_id");
        assertThat(messageEntities.isEmpty(),is(false));

        messageRepository.delete(messageEntity.getId());

        message = messageRepository.findOne(messageEntity.getId());

        assertNull(message);
    }

    @Test
    public void messageStatusEntityReadWriteTest(){
        MessageStatusEntity messageStatusEntity = new MessageStatusEntity();
        messageStatusEntity.setSenderId("sender_id");
        messageStatusEntity.setUserId("user_id");
        messageStatusEntity.setStatusDate(123456124356L);
        messageStatusEntity.setStatus(MessageStatus.DELIVERED);
        messageStatusEntity.setMessageId("message_id");
        messageStatusEntity = messageStatusRepository.save(messageStatusEntity);

        MessageStatusEntity message = messageStatusRepository.findOne(messageStatusEntity.getId());

        assertEquals(messageStatusEntity,message);

        List<MessageStatusEntity> messageStatusEntities = messageStatusRepository.findByMessageId("message_id");
        assertThat(messageStatusEntities.isEmpty(),is(false));

        messageStatusRepository.delete(messageStatusEntity.getId());

        message = messageStatusRepository.findOne(messageStatusEntity.getId());

        assertNull(message);
    }

    @Test
    public void profileSettingsEntityReadWriteTest(){
        ProfileSettingsEntity profileSettingsEntity = new ProfileSettingsEntity();
        profileSettingsEntity.setProfileId("id");
        profileSettingsEntity = profileSettingsRepository.save(profileSettingsEntity);

        ProfileSettingsEntity message = profileSettingsRepository.findOne(profileSettingsEntity.getId());

        assertEquals(profileSettingsEntity,message);

        ProfileSettingsEntity profileSettingsEntities = profileSettingsRepository.findByProfileId("id");
        assertNotNull(profileSettingsEntities);

        profileSettingsRepository.delete(profileSettingsEntity.getId());

        message = profileSettingsRepository.findOne(profileSettingsEntity.getId());

        assertNull(message);
    }
}


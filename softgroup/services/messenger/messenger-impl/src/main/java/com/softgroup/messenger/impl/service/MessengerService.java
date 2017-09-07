package com.softgroup.messenger.impl.service;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.*;
import com.softgroup.common.exceptions.SoftgroupException;
import com.softgroup.common.protocol.enumeration.ConversationType;
import com.softgroup.messenger.api.dto.DTOConversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maxim on 09.08.17.
 */
@Service
public class MessengerService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ConversationMemberRepository conversationMemberRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageStatusRepository messageStatusRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileEntity> loadIndividualConversationMemberProfiles(String userId, List<String> members){
        List<ProfileEntity> userAndMember;
        if(members.size()==1){
            userAndMember = loadConversationMemberProfiles(userId,members);
        }else {
            throw new SoftgroupException("Individual conversation must have only one member");
        }
        if (userAndMember.size()==2){
            return userAndMember;
        }else {
            throw new SoftgroupException("Can't find your member");
        }
    }

    public List<ProfileEntity> loadGroupConversationMemberProfiles(String userId, List<String> members){
        List<ProfileEntity> userAndMember;
        if(members.size()>1){
            userAndMember = loadConversationMemberProfiles(userId,members);
        }else {
            throw new SoftgroupException("Individual conversation must have more than one member");
        }
        if (userAndMember.size()>2){
            return userAndMember;
        }else {
            throw new SoftgroupException("Count of real users less than 3");
        }
    }

    public ConversationEntity getConversationByProfiles(List<ProfileEntity> profileEntities){
        List<String> ids = profileEntities.parallelStream()
                .map(ProfileEntity::getId).collect(Collectors.toList());
        return conversationRepository.findOneByMemberIds(ids);
    }

    public ConversationEntity createConversation(List<ProfileEntity> profileEntities, ConversationType conversationType, String adminId){
        String conversationName = profileEntities.stream()
                .map(ProfileEntity::getName)
                .collect(Collectors.joining(", "));

        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setName(conversationName);
        conversationEntity.setType(conversationType);
        conversationEntity.setExists(true);
        conversationEntity.setMembersCount(profileEntities.size());
        conversationEntity.setCreateTime(new Date().getTime());
        conversationEntity.setLogoImageUri("/default_conversation.jpg");

        if (conversationType.equals(ConversationType.INDIVIDUAL)){
            conversationEntity.setAdminId(null);
        }else {
            conversationEntity.setAdminId(adminId);
        }
        ConversationEntity conversationEntityInDatabase = conversationRepository.save(conversationEntity);
        return conversationEntityInDatabase;
    }

    public void addMembersToConversation(String conversationId, List<ProfileEntity> profileEntities){
        Long currentTime = new Date().getTime();
        profileEntities.stream().forEach(profileEntity -> {
            ConversationMemberEntity conversationMemberEntity = new ConversationMemberEntity();
            conversationMemberEntity.setConversationId(conversationId);
            conversationMemberEntity.setDeleted(false);
            conversationMemberEntity.setJoinDate(currentTime);
            conversationMemberEntity.setMemberId(profileEntity.getId());
            conversationMemberRepository.save(conversationMemberEntity);
        });
    }

    public ConversationEntity getConversationById(String conversationId){
        return conversationRepository.findOne(conversationId);
    }

    public Boolean isUserAdmin(String userId, ConversationEntity conversationEntity){
        if(conversationEntity==null){
            return false;
        }else{
            return conversationEntity.getAdminId().equals(userId);
        }
    }

    public void deleteUsersFromConversation(String conversationId){
        List<ConversationMemberEntity> conversationMembers = conversationMemberRepository.findByConversationIdAndAndDeletedIsFalse(conversationId);
        List<ConversationMemberEntity> deletedConversationMembers = conversationMembers.stream().map(conversationMemberEntity ->{
            conversationMemberEntity.setDeleted(true);
            return conversationMemberEntity;
        }).collect(Collectors.toList());
        conversationMemberRepository.save(deletedConversationMembers);
    }

    public void deleteConversation(String conversationId){
        ConversationEntity conversation = conversationRepository.findOne(conversationId);
        if(conversation.getExists()==false){
            throw new SoftgroupException("Conversation already deleted");
        }
        conversation.setExists(false);
        conversationRepository.save(conversation);
    }

    private List<ProfileEntity> loadConversationMemberProfiles(String userId, List<String> members){
        List<String> userAndMemberList = new ArrayList<>();
        userAndMemberList.add(userId);
        userAndMemberList.addAll(members);

        return userAndMemberList.parallelStream().distinct().map(s -> {
            return profileRepository.findOne(s);
        }).filter(profileEntity -> profileEntity!=null).collect(Collectors.toList());
    }

    public List<ConversationEntity> getGroupConversationForUser(String userId){
        return conversationRepository.findAllByMemberIdAAndType(userId,ConversationType.GROUP);
    }

    public List<ConversationEntity> getIndividualConversationForUser(String userId){
        return conversationRepository.findAllByMemberIdAAndType(userId,ConversationType.INDIVIDUAL);
    }

    public List<ConversationEntity> getAllConversationForUser(String userId){
        return conversationRepository.findAllByMemberId(userId);
    }

}

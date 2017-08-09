package com.softgroup.messenger.impl.service;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.*;
import com.softgroup.common.exceptions.SoftgroupException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    private List<ProfileEntity> loadConversationMemberProfiles(String userId, List<String> members){
        List<String> userAndMemberList = new ArrayList<>();
        userAndMemberList.add(userId);
        userAndMemberList.addAll(members);

        return userAndMemberList.parallelStream().distinct().map(s -> {
            return profileRepository.findOne(s);
        }).filter(profileEntity -> profileEntity!=null).collect(Collectors.toList());
    }
}

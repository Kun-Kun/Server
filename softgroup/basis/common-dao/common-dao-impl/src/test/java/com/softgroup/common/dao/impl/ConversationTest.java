package com.softgroup.common.dao.impl;

import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.dao.impl.repositories.ConversationMemberRepository;
import com.softgroup.common.dao.impl.repositories.ConversationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class ConversationTest {

    @Autowired
    private ConversationMemberRepository conversationMemberRepository;
    @Autowired
    private ConversationRepository conversationRepository;

    @Test
    public void findConversation(){
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        System.out.println(conversationRepository.findOneByMemberIds(ids));
    }
}

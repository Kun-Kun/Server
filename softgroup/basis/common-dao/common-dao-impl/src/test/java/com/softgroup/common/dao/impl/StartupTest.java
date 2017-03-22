package com.softgroup.common.dao.impl;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Odin on 04.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class StartupTest {

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void test(){
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId("id");
        profileEntity.setName("test_name");

        profileEntity = profileRepository.save(profileEntity);

        profileEntity = profileRepository.save(profileEntity);

        ProfileEntity profile = profileRepository.findOne("id");

        List<ProfileEntity> profileEntities = profileRepository.findByName("name_2");

        List<ProfileEntity> profileEntitiesByQuery = profileRepository.findByNameQuery("name_2");

    }
}

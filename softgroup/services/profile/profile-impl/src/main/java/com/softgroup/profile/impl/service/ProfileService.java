package com.softgroup.profile.impl.service;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.api.entities.ContactPhoneNumberEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.ContactPhoneNumberRepository;
import com.softgroup.common.dao.impl.repositories.ContactRepository;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Todo make interface
@Service
public class ProfileService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactPhoneNumberRepository contactPhoneNumberRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public void removePhoneNumbers(String userId, String name, List<String> numbers){
        contactPhoneNumberRepository.removeAllByNameAndUserIdAndPhoneNumbers(userId,name,numbers);
        contactRepository.removeEmptyByNameAndUserId(userId,name);
    }

    public void addPhoneNumbers(String userId, String name, List<String> numbers){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setName(name);
        contactEntity.setUserId(userId);
        ContactEntity finalContactEntity = contactRepository.save(contactEntity);
        numbers.forEach(number -> {
            ContactPhoneNumberEntity contactPhoneNumberEntity = new ContactPhoneNumberEntity();
            contactPhoneNumberEntity.setContactId(finalContactEntity.getId());
            contactPhoneNumberEntity.setPhoneNumber(number);
            contactPhoneNumberRepository.save(contactPhoneNumberEntity);
        });

    }

    public List<ProfileEntity> getContactProfiles(String userId){
        return profileRepository.findProfileFromUserContactList(userId);
    }

    public ProfileEntity getUserProfile(String userId){
        return profileRepository.findOne(userId);
    }

}

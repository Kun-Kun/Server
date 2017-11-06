package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ContactPhoneNumberEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface ContactPhoneNumberRepository extends PagingAndSortingRepository<ContactPhoneNumberEntity, String> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE pn FROM messenger.contact_phone_numbers pn LEFT JOIN messenger.contacts c ON pn.contact_id = c.id WHERE c.name = :name AND c.user_id = :userId AND pn.phone_number IN :phoneNumbers")
    void removeAllByNameAndUserIdAndPhoneNumbers(@Param(value = "userId") String userId, @Param(value = "name") String name, @Param(value = "phoneNumbers") List<String> phoneNumbers);
/*
    @Query(nativeQuery = true, value = "SELECT * FROM messenger.contact_phone_numbers pn LEFT JOIN messenger.contacts c ON pn.contact_id = c.id WHERE c.name = :name AND c.user_id = :userId AND pn.phone_number IN :phoneNumbers ")
    ContactPhoneNumberEntity findFirstByNameAndUserIdAndPhoneNumbers(@Param(value = "userId") String userId, @Param(value = "name") String name, @Param(value = "phoneNumbers") List<String> phoneNumbers);
*/
}

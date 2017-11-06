package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ContactEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, String> {

    List<ContactEntity> findByUserId(String userId);

    List<ContactEntity> findByUserIdAndName(String userId, String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE c FROM messenger.contacts c LEFT JOIN messenger.contact_phone_numbers pn ON c.id = pn.contact_id WHERE pn.id IS NULL AND c.user_id = :userId AND c.name = :name")
    void removeEmptyByNameAndUserId(@Param(value = "userId") String userId, @Param(value = "name") String name);

}

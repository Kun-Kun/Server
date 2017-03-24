package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ContactEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by user on 25.03.2017.
 */
public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, String> {

    ContactEntity findById(String id);

    List<ContactEntity> findByUserId(String userId);

    List<ContactEntity> findByUserIdAndName(String userId, String name);
}

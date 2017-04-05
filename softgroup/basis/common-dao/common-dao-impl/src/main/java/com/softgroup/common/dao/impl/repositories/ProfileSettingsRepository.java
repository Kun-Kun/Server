package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by user on 25.03.2017.
 */
public interface ProfileSettingsRepository extends PagingAndSortingRepository<ProfileSettingsEntity, String> {

    ProfileSettingsEntity findByProfileId(String profileId);

}

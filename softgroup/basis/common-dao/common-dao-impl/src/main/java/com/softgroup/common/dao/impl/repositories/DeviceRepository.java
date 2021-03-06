package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by user on 24.03.2017.
 */
public interface DeviceRepository extends PagingAndSortingRepository<DeviceEntity, String> {

    List<DeviceEntity> findByUserId(String userId);

    DeviceEntity findFirstByUserIdAndDeviceId(String userId,String deviceId);
}

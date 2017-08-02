package com.softgroup.authorization.api.cache;

import com.softgroup.common.cache.ExpirationDatabase;

/**
 * Created by user on 13.04.2017.
 * Expiration map with phone - registrationRequestUUID mapping
 */
public interface PhoneNumberUUIDCache extends ExpirationDatabase<String,String> {

}

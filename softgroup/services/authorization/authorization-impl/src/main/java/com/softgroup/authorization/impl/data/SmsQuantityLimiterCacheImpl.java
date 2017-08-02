package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.SmsQuantityLimiterCache;
import com.softgroup.common.cache.ExpirationDatabaseService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 31.07.2017.
 */

public class SmsQuantityLimiterCacheImpl extends ExpirationDatabaseService<String,String> implements SmsQuantityLimiterCache {

    public SmsQuantityLimiterCacheImpl() {
        super(20000, 2, TimeUnit.MINUTES);
    }
}

package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.SmsQuantityLimiterCache;
import com.softgroup.common.cache.SimpleExpirationDatabase;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 31.07.2017.
 */

public class SmsQuantityLimiterCacheImpl extends SimpleExpirationDatabase<String,String> implements SmsQuantityLimiterCache {

    public SmsQuantityLimiterCacheImpl() {
        super(20000, 2, TimeUnit.MINUTES);
    }
}

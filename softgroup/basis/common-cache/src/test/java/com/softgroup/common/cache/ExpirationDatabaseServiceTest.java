package com.softgroup.common.cache;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 14.04.2017.
 */
public class ExpirationDatabaseServiceTest {

    private ExpirationDatabase<String,String> cache = new ExpirationDatabaseService<>(5,2, TimeUnit.SECONDS);

    @Before
    public void prepare(){
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
    }

    @Test
    public void get() throws Exception {
        assertThat(cache.get("key1"),is("value1"));
        assertThat(cache.get("key2"),is("value2"));
        assertThat(cache.get("key3"),is("value3"));
    }

    @Test
    public void put() throws Exception {
        cache.put("key4","value4");
        assertThat(cache.get("key4"),is("value4"));
    }

    @Test
    public void invalidate() throws Exception {
        cache.put("key5","value5");
        assertThat(cache.get("key5"),is("value5"));
        cache.invalidate("key5");
        assertNull(cache.get("key5"));
    }

    @Test
    public void pop() throws Exception {
        cache.put("key6","value6");
        assertThat(cache.get("key6"),is("value6"));
        assertThat(cache.pop("key6"),is("value6"));
        assertNull(cache.get("key6"));
    }

    @Test
    public void size() throws Exception {
        assertThat(cache.size(),is(3L));
    }

    @Test
    public void testExpiration() throws Exception {
        assertThat(cache.size(),is(3L));
        Thread.sleep(2000);
        cache.put("key6","value6");
        Thread.sleep(1000);
        assertThat(cache.size(),is(1L));
        assertNull(cache.get("key1"));
        assertNull(cache.get("key2"));
        assertNull(cache.get("key3"));
        assertThat(cache.get("key6"),is("value6"));
    }

    @Test
    public void overflowTest() throws Exception {
        cache.put("key4","value4");
        cache.put("key5","value5");
        cache.put("key6","value6");
        assertThat(cache.size(),is(5L));
        assertNull(cache.get("key1"));
        assertNotNull(cache.get("key2"));
        assertNotNull(cache.get("key3"));
        assertNotNull(cache.get("key4"));
        assertNotNull(cache.get("key5"));
        assertNotNull(cache.get("key6"));
    }
}
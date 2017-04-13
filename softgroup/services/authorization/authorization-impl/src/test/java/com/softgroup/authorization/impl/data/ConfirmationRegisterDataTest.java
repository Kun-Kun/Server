package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.message.RegisterRequest;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 13.04.2017.
 */
public class ConfirmationRegisterDataTest {

    private RegisterRequest request;

    private ConfirmationRegisterData data;

    @Before
    public void prepare(){
        request = new RegisterRequest();
        request.setDeviceId("device_id1");
        request.setPhoneNumber("063-12-34-567");
        request.setLocaleCode("ua-ua");
        data = new ConfirmationRegisterData(request);

    }

    @Test
    public void getRequest() throws Exception {
        System.out.println(data.getRequest());
    }

    @Test
    public void getRegistrationRequestUUID() throws Exception {
        System.out.println(data.getRegistrationRequestUUID());
    }

    @Test
    public void getConfirmationCode() throws Exception {
        System.out.println(data.getConfirmationCode());

    }

}
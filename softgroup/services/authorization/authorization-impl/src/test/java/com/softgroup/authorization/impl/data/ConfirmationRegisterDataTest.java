package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.message.RegisterRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 13.04.2017.
 */
public class ConfirmationRegisterDataTest {

    private RegisterRequest request;

    private ArrayList<ConfirmationRegisterData> data = new ArrayList<>();

    @Before
    public void prepare(){
        request = new RegisterRequest();
        request.setDeviceId("device_id1");
        request.setPhoneNumber("063-12-34-567");
        request.setLocaleCode("ua-ua");
        for (int i = 0; i <100 ; i++) {
            data.add(new ConfirmationRegisterData(request));
        }
    }

    //Check that generators generate unique value for different RegistrationRequests
    @Test
    public void getUniqueRegistrationRequestUUIDAndCode() throws Exception {
        for (ConfirmationRegisterData registerData:data) {
            assertNotNull(registerData.getRegistrationRequestUUID());
            for (ConfirmationRegisterData registerData1:data) {
                if(registerData!=registerData1) {
                    assertNotEquals(registerData.getRegistrationRequestUUID(), registerData1.getRegistrationRequestUUID());
                    assertNotEquals(registerData.getConfirmationCode(), registerData1.getConfirmationCode());
                }
            }
        }

    }

}
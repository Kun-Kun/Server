package com.softgroup.authorization.impl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 30.07.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationServiceUnitTest {
//todo make tests
    @InjectMocks
    private AuthorizationServiceImpl authorizationService;

/*
    @Test
    public void testValidPhoneNumbers(){
        List<String> validPhones = new ArrayList<>();
        validPhones.add("+380123456789");
        for(String number: validPhones){
            assertThat(authorizationService.checkPhoneNumber(number),is(true));
        }
    }

    @Test
    public void testInvalidPhoneNumbers(){
        List<String> inValidPhones = new ArrayList<>();
        inValidPhones.add("+3801234567890");
        inValidPhones.add("38012345678");
        inValidPhones.add("380123456a9");
        inValidPhones.add("38-012-345-67-89");
        inValidPhones.add("38 012 345 6789");

        for(String number: inValidPhones){
            assertThat(authorizationService.checkPhoneNumber(number),is(false));
        }
    }

    @Test
    public void testPhoneCleaner(){
        List<String> inValidPhones = new ArrayList<>();
        inValidPhones.add("+38(012)3456789");
        inValidPhones.add("+38-012-345-67-89");
        inValidPhones.add("+38 (012)34-567 89");
        inValidPhones.add("+38-012-345-67-89");
        inValidPhones.add("+38 012 345 6789");

        for(String number: inValidPhones){
            assertThat(authorizationService.clearPhoneNumber(number),is("+380123456789"));
        }
    }
    */
}

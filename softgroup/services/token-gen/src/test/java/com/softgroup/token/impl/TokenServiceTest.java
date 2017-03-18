package com.softgroup.token.impl;

import com.sofrgroup.token.api.TokenGeneratorService;
import com.softgroup.token.config.TokenServiceAppCfg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by user on 17.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TokenServiceAppCfg.class})
public class TokenServiceTest {
    @Autowired
    private TokenGeneratorService tokenGenerator;
    private String firstLTToken;
    private String firstSTToken;

    @Test
    public void isTokenGeneratorExist(){
        assertNotNull(tokenGenerator);
    }

    @Test
    public void createLTToken() throws Exception {
        assertNotNull(firstLTToken);
        String secondLTToken = tokenGenerator.createLTToken("1234567890","0987654321");
        assertNotNull(secondLTToken);
        System.out.println(firstLTToken);
        System.out.println(secondLTToken);
        assertNotEquals(firstLTToken,secondLTToken);

        assertThat(tokenGenerator.createLTToken(null,"0987654321"),null);
        assertThat(tokenGenerator.createLTToken("123456789",null),null);
        assertThat(tokenGenerator.createLTToken(null,null),null);
    }

    @Test
    public void createTempToken() throws Exception {

    }

    @Test
    public void validateToken() throws Exception {
        assertThat(tokenGenerator.validateLTToken(firstLTToken),is(true));
        assertThat(tokenGenerator.validateSTToken(firstSTToken),is(true));
    }

    @Before
    public void generateTokens(){
        firstLTToken = tokenGenerator.createLTToken("1234567890","0987654321");
        firstSTToken = tokenGenerator.createSTToken(firstLTToken);
    }

}
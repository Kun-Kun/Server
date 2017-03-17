package com.softgroup.token.impl;

import com.sofrgroup.token.api.TokenGeneratorService;
import com.softgroup.token.config.TokenServiceAppCfg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void createToken() throws Exception {
        assertNotNull(firstLTToken);
        String secondLTToken = tokenGenerator.createToken("1234567890","0987654321");
        assertNotNull(secondLTToken);
        assertNotEquals(firstLTToken,secondLTToken);

        assertThat(tokenGenerator.createToken(null,"0987654321"),null);
        assertThat(tokenGenerator.createToken("123456789",null),null);
        assertThat(tokenGenerator.createToken(null,null),null);
    }

    @Test
    public void createTempToken() throws Exception {

    }

    @Test
    public void validateToken() throws Exception {

    }

    @Before
    public void generateTokens(){
        firstLTToken = tokenGenerator.createToken("1234567890","0987654321");
        firstSTToken = tokenGenerator.createTempToken(firstLTToken);
    }

}
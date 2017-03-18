package com.softgroup.token.impl;

import com.sofrgroup.token.api.TokenGeneratorService;
import com.softgroup.token.config.TokenServiceAppCfg;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

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
    private String firstExpiredLTToken;
    private String secondNotExpiredLTToken;

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
       // assertNotEquals(firstLTToken,secondLTToken);

        assertNull(tokenGenerator.createLTToken(null,"0987654321"));
        assertNull(tokenGenerator.createLTToken("123456789",null));
        assertNull(tokenGenerator.createLTToken(null,null));
    }

    @Test
    public void createTempToken() throws Exception {

    }

    @Test
    public void validateToken() throws Exception {
        assertThat(tokenGenerator.validateLTToken(firstLTToken),is(true));
        assertThat(tokenGenerator.validateSTToken(firstSTToken),is(true));
        assertThat(tokenGenerator.validateLTToken(firstExpiredLTToken),is(false));
        assertThat(tokenGenerator.validateLTToken(secondNotExpiredLTToken),is(true));
    }

    @Before
    public void generateTokens(){
        firstLTToken = tokenGenerator.createLTToken("1234567890","0987654321");
        firstSTToken = tokenGenerator.createSTToken(firstLTToken);
        //01/01/2015 @ 12:00am (UTC)
        firstExpiredLTToken = generateExpiredLTToken(new Date(1420070400000L),"1234567890","0987654321");
        //now
        secondNotExpiredLTToken = generateExpiredLTToken(new Date(),"1234567890","0987654321");
    }


    private String generateExpiredLTToken(Date date,String deviceId,String userId){
        String keyLT = "kHv4PXv0OiM4V9U0mgwXD58Mq8ooVZJ9";
        if (deviceId == null || userId == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        JwtBuilder jwtBuilder = Jwts.builder();
        Claims tokenData = Jwts.claims()
                .setExpiration(calendar.getTime())
                .setIssuedAt(date);
        tokenData.put("tokenType", "longTerm");
        tokenData.put("userID", userId);
        tokenData.put("deviceID", deviceId);
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyLT).compact();

    }
}
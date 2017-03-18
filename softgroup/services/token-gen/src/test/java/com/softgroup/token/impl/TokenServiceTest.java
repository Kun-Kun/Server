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
    private String expiredLTToken;
    private String futureLTToken;

    private String firstSTToken;
    private String expiredSTToken;
    private String futureSTToken;

    @Test
    public void isTokenGeneratorExist(){
        assertNotNull(tokenGenerator);
    }

    @Test
    public void createLTToken() throws Exception {
        assertNotNull(firstLTToken);
        String secondLTToken = tokenGenerator.createLTToken("1234567890","0987654321");
        assertNotNull(secondLTToken);

        assertNull(tokenGenerator.createLTToken(null,"0987654321"));
        assertNull(tokenGenerator.createLTToken("123456789",null));
        assertNull(tokenGenerator.createLTToken(null,null));

    }

    @Test
    public void createSTToken() throws Exception {
        assertNotNull(firstSTToken);
        String secondSTToken = tokenGenerator.createSTToken(firstLTToken);
        assertNotNull(secondSTToken);

        assertNull(tokenGenerator.createSTToken(null));
        assertNull(tokenGenerator.createSTToken("very.wrong.token"));
        //verify that short term token can't be generated from outdated token or other short term token
        assertNull(tokenGenerator.createSTToken(expiredLTToken));
        assertNull(tokenGenerator.createSTToken(futureLTToken));
        assertNull(tokenGenerator.createSTToken(secondSTToken));

    }

    @Test
    public void validateTokens() throws Exception {
        assertThat(tokenGenerator.validateLTToken(firstLTToken),is(true));
        assertThat(tokenGenerator.validateLTToken(expiredLTToken),is(false));
        assertThat(tokenGenerator.validateLTToken(futureLTToken),is(false));

        assertThat(tokenGenerator.validateSTToken(firstSTToken),is(true));
        assertThat(tokenGenerator.validateSTToken(expiredSTToken),is(false));
        assertThat(tokenGenerator.validateSTToken(futureSTToken),is(false));
    }

    @Before
    public void generateTokens(){
        //generate normal long/short term tokens
        firstLTToken = tokenGenerator.createLTToken("1234567890","0987654321");
        firstSTToken = tokenGenerator.createSTToken(firstLTToken);
        //01/01/2015 @ 12:00am (UTC)
        expiredLTToken = generateTokenAnyDate(new Date(1420070400000L),"1234567890","0987654321","kHv4PXv0OiM4V9U0mgwXD58Mq8ooVZJ9","longTerm");
        //Thu, 02 Jan 2420 00:00:00 GMT
        futureLTToken = generateTokenAnyDate(new Date(14200704000000L),"1234567890","0987654321","kHv4PXv0OiM4V9U0mgwXD58Mq8ooVZJ9","longTerm");

        //01/01/2015 @ 12:00am (UTC)
        expiredSTToken = generateTokenAnyDate(new Date(1420070400000L),"1234567890","0987654321","AMVvu8OMlipxmr8l73Eo9NXlA5AVNJr1","shortTerm");
        //Thu, 02 Jan 2420 00:00:00 GMT
        futureSTToken = generateTokenAnyDate(new Date(14200704000000L),"1234567890","0987654321","AMVvu8OMlipxmr8l73Eo9NXlA5AVNJr1","shortTerm");

    }

    //Generate valid tokens from date for a month
    private String generateTokenAnyDate(Date date,String deviceId,String userId, String key,String type){

        if (deviceId == null || userId == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        JwtBuilder jwtBuilder = Jwts.builder();
        Claims tokenData = Jwts.claims()
                .setExpiration(calendar.getTime())
                .setIssuedAt(date);
        tokenData.put("tokenType", type);
        tokenData.put("userID", userId);
        tokenData.put("deviceID", deviceId);
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();

    }
}
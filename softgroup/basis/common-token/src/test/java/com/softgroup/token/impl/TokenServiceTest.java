package com.softgroup.token.impl;

import com.sofrgroup.token.api.TokenGeneratorService;
import com.sofrgroup.token.api.TokenType;
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

import static com.sofrgroup.token.api.TokenType.LONG_TERM;
import static com.sofrgroup.token.api.TokenType.SHORT_TERM;
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
    private String badLTToken;

    private String firstSTToken;
    private String expiredSTToken;
    private String futureSTToken;
    private String badSTToken;

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
        assertThat(tokenGenerator.validateToken(firstLTToken, LONG_TERM),is(true));
        assertThat(tokenGenerator.validateToken(expiredLTToken,LONG_TERM),is(false));
        assertThat(tokenGenerator.validateToken(futureLTToken,LONG_TERM),is(false));

        assertThat(tokenGenerator.validateToken(firstSTToken,SHORT_TERM),is(true));
        assertThat(tokenGenerator.validateToken(expiredSTToken,SHORT_TERM),is(false));
        assertThat(tokenGenerator.validateToken(futureSTToken,SHORT_TERM),is(false));

        assertThat(tokenGenerator.validateToken(badSTToken,SHORT_TERM),is(false));
        assertThat(tokenGenerator.validateToken(badLTToken,LONG_TERM),is(false));
    }

    @Before
    public void generateTokens(){
        KeyFactory keyFactory = new KeyFactory();
        //generate normal long/short term tokens
        firstLTToken = tokenGenerator.createLTToken("1234567890","0987654321");
        firstSTToken = tokenGenerator.createSTToken(firstLTToken);
        //01/01/2015 @ 12:00am (UTC)
        expiredLTToken = generateTokenAnyDate(new Date(1420070400000L),"1234567890","0987654321",keyFactory.getKey(LONG_TERM),LONG_TERM);
        //Thu, 02 Jan 2420 00:00:00 GMT
        futureLTToken = generateTokenAnyDate(new Date(14200704000000L),"1234567890","0987654321",keyFactory.getKey(LONG_TERM),LONG_TERM);

        //01/01/2015 @ 12:00am (UTC)
        expiredSTToken = generateTokenAnyDate(new Date(1420070400000L),"1234567890","0987654321",keyFactory.getKey(SHORT_TERM),SHORT_TERM);
        //Thu, 02 Jan 2420 00:00:00 GMT
        futureSTToken = generateTokenAnyDate(new Date(14200704000000L),"1234567890","0987654321",keyFactory.getKey(SHORT_TERM),SHORT_TERM);
        //generate bad token signed with bad key
        badLTToken = generateTokenAnyDate(new Date(),"1234567890","0987654321","bad key",LONG_TERM);
        badSTToken = generateTokenAnyDate(new Date(),"1234567890","0987654321","bad key",SHORT_TERM);

    }

    //Generate valid tokens from date for a month
    private String generateTokenAnyDate(Date date,String deviceId,String userId, String key,TokenType type){

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
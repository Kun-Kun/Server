package com.softgroup.token.impl;

import com.softgroup.common.exceptions.TokenException;
import com.softgroup.token.api.TokenGeneratorService;
import com.softgroup.token.api.TokenType;
import com.softgroup.token.config.TokenServiceAppCfg;
import io.jsonwebtoken.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

import static com.softgroup.token.api.TokenType.LONG_TERM;
import static com.softgroup.token.api.TokenType.SHORT_TERM;
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

    private String firstLongTermToken;
    private String expiredLongTermToken;
    private String futureLongTermToken;
    private String badLongTermToken;

    private String firstShortTermToken;
    private String expiredShortTermToken;
    private String futureShortTermToken;
    private String badShortTermToken;

    @Test
    public void isTokenGeneratorExist(){
        assertNotNull(tokenGenerator);
    }

    @Test
    public void createLongTermToken() throws Exception {
        assertNotNull(firstLongTermToken);
        String secondLongTermToken = tokenGenerator.createLongTermToken("1234567890","0987654321");
        assertNotNull(secondLongTermToken);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullDeviceArgumentCreateLongTerm(){
        assertNull(tokenGenerator.createLongTermToken(null,"0987654321"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullUserArgumentCreateLongTerm() {
        assertNull(tokenGenerator.createLongTermToken("123456789", null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullArgumentCreateLongTerm() {
        assertNull(tokenGenerator.createLongTermToken(null, null));
    }

    @Test
    public void createShortTermToken() throws Exception {
        assertNotNull(firstShortTermToken);
        String secondShortTermToken = tokenGenerator.createShortTermToken(firstLongTermToken);
        assertNotNull(secondShortTermToken);

        //verify that short term token can't be generated from outdated token or other short term token
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullArgumentCreateShortTerm() {
        assertNull(tokenGenerator.createShortTermToken(null));
    }
    //@Test(expected = JwtException.class)
    public void wrongTokenCreateShortTerm() {
        assertNull(tokenGenerator.createShortTermToken("very.wrong.token"));
    }

    //@Test(expected = JwtException.class)
    public void expiredTokenCreateShortTerm() {
        assertNull(tokenGenerator.createShortTermToken(expiredLongTermToken));
    }

    //@Test(expected = JwtException.class)
    public void futureTokenCreateShortTerm() {
        assertNull(tokenGenerator.createShortTermToken(futureLongTermToken));
    }

    //@Test(expected = JwtException.class)
    public void shortTokenCreateShortTerm() {
        String secondShortTermToken = tokenGenerator.createShortTermToken(firstLongTermToken);
        assertNull(tokenGenerator.createShortTermToken(secondShortTermToken));
    }

    public void validateRightTokens() throws Exception {
        assertThat(tokenGenerator.validateToken(firstLongTermToken, LONG_TERM),is(true));
        assertThat(tokenGenerator.validateToken(firstShortTermToken,SHORT_TERM),is(true));
    }

    @Test(expected = TokenException.class)
    public void validateExpiredLongTermToken() throws Exception {
        assertThat(tokenGenerator.validateToken(expiredLongTermToken,LONG_TERM),is(false));
    }

    @Test(expected = TokenException.class)
    public void validateFutureLongTermToken() throws Exception {
        assertThat(tokenGenerator.validateToken(futureLongTermToken,LONG_TERM),is(false));
    }

    @Test(expected = TokenException.class)
    public void validateExpiredShortTermToken() throws Exception {
        assertThat(tokenGenerator.validateToken(expiredShortTermToken,SHORT_TERM),is(false));
    }

    @Test(expected = TokenException.class)
    public void validateFutureShortTermToken() throws Exception {
        assertThat(tokenGenerator.validateToken(futureShortTermToken,SHORT_TERM),is(false));
    }

    @Test(expected = TokenException.class)
    public void validateBadLongTermToken() throws Exception {
        assertThat(tokenGenerator.validateToken(badLongTermToken,LONG_TERM),is(false));
    }

    @Test(expected = TokenException.class)
    public void validateBadShortTermToken() throws Exception {
        assertThat(tokenGenerator.validateToken(badShortTermToken,SHORT_TERM),is(false));
    }

    @Before
    public void generateTokens(){
        KeyFactory keyFactory = new KeyFactory();
        //generate normal long/short term tokens
        firstLongTermToken = tokenGenerator.createLongTermToken("1234567890","0987654321");
        firstShortTermToken = tokenGenerator.createShortTermToken(firstLongTermToken);
        //01/01/2015 @ 12:00am (UTC)
        expiredLongTermToken = generateTokenAnyDate(new Date(1420070400000L),"1234567890","0987654321",keyFactory.getKey(LONG_TERM),LONG_TERM);
        //Thu, 02 Jan 2420 00:00:00 GMT
        futureLongTermToken = generateTokenAnyDate(new Date(14200704000000L),"1234567890","0987654321",keyFactory.getKey(LONG_TERM),LONG_TERM);

        //01/01/2015 @ 12:00am (UTC)
        expiredShortTermToken = generateTokenAnyDate(new Date(1420070400000L),"1234567890","0987654321",keyFactory.getKey(SHORT_TERM),SHORT_TERM);
        //Thu, 02 Jan 2420 00:00:00 GMT
        futureShortTermToken = generateTokenAnyDate(new Date(14200704000000L),"1234567890","0987654321",keyFactory.getKey(SHORT_TERM),SHORT_TERM);
        //generate bad token signed with bad key
        badLongTermToken = generateTokenAnyDate(new Date(),"1234567890","0987654321","bad key",LONG_TERM);
        badShortTermToken = generateTokenAnyDate(new Date(),"1234567890","0987654321","bad key",SHORT_TERM);

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

    @Test
    //Generate valid tokens from date for a month
    public void generateTokenAnyDate1(){

        KeyFactory factory = new KeyFactory();

        Date date = new Date();
        String deviceId = "00000";
        String userId = "1";
        String key = factory.getKey(TokenType.SHORT_TERM);
        TokenType type = TokenType.SHORT_TERM;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);
        JwtBuilder jwtBuilder = Jwts.builder();
        Claims tokenData = Jwts.claims()
                .setExpiration(calendar.getTime())
                .setIssuedAt(date);
        tokenData.put("tokenType", type);
        tokenData.put("userID", userId);
        tokenData.put("deviceID", deviceId);
        jwtBuilder.setClaims(tokenData);
        System.out.println(jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact());

    }
}
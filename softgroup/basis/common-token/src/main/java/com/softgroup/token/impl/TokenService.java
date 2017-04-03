package com.softgroup.token.impl;

import com.softgroup.common.exceptions.TokenException;
import com.softgroup.token.api.JwtUserIdentifier;
import com.softgroup.token.api.TokenGeneratorService;
import com.softgroup.token.api.TokenType;
import io.jsonwebtoken.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

import static com.softgroup.token.api.TokenType.*;

/**
 * Created by user on 17.03.2017.
 */


@Service
public class TokenService implements TokenGeneratorService {

    private Log log = LogFactory.getLog(TokenService.class);

    private static final String TOKEN_TYPE_DATA_KEY = "tokenType";
    private static final String USER_ID_DATA_KEY = "userID";
    private static final String DEVICE_ID_DATA_KEY = "deviceID";

    private KeyFactory keyFactory = new KeyFactory();


    //Long term token lifetime in month
    private int longTermTokenLifetime = 12;
    //Short term token lifetime in minute
    private int shortTermTokenLifetime = 10;

    public String createLongTermToken(String deviceId, String userId) {
        if (deviceId == null || userId == null) {
            throw new IllegalArgumentException("Device ID or user ID cannot be null. ");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, longTermTokenLifetime);
        JwtBuilder jwtBuilder = Jwts.builder();
        Claims tokenData = Jwts.claims()
                .setExpiration(calendar.getTime())
                .setIssuedAt(new Date());
        tokenData.put(TOKEN_TYPE_DATA_KEY, LONG_TERM);
        tokenData.put(USER_ID_DATA_KEY, userId);
        tokenData.put(DEVICE_ID_DATA_KEY, deviceId);
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyFactory.getKey(LONG_TERM)).compact();
    }

    public String createShortTermToken(String token) throws TokenException{
        try {
            //validate token
            validateToken(token,LONG_TERM);

            //Parse token
            Claims body = parseTokenBody(token,keyFactory.getKey(LONG_TERM));

            //token can be generated only from long term token
            if(body.get(TOKEN_TYPE_DATA_KEY).equals(SHORT_TERM.name())){
                TokenException exception = new TokenException("Token can be generated only from long term token");
                log.error("An error occurred during creating short term token",exception);
                throw exception;
            }

            //get body and replace date with new value
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, shortTermTokenLifetime);
            body.replace(TOKEN_TYPE_DATA_KEY, SHORT_TERM);
            body.setIssuedAt(new Date());
            body.setExpiration(calendar.getTime());

            //generate new token
            JwtBuilder jwtBuilder = Jwts.builder()
            .setExpiration(calendar.getTime())
            .setClaims(body);

            return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyFactory.getKey(SHORT_TERM)).compact();

        } catch (JwtException exception) {
            //log this jwt error
            log.error("An error occurred during creating short term token",exception);
            // throw exception;
            throw new TokenException("An error occurred during creating short term token",exception);
        }
    }


    public boolean validateToken(String token,TokenType type) {
        return getUserIdentifier(token,type)!=null;
    }

    @Override
    public JwtUserIdentifier getUserIdentifier(String token, TokenType type) throws TokenException{
        //Parse and validate token
        try {
            if(token==null){
                throw new IllegalArgumentException("Token cannot be null. ");
            }

            Claims body = parseTokenBody(token,keyFactory.getKey(type));

            if(body.getIssuedAt().after(new Date())){
                TokenException exception = new TokenException("Error.This token created in future");
                log.error("An error occurred during parsing a user identifier",exception);
                throw exception;
            }

            return new JwtUserIdentifier(body.get(USER_ID_DATA_KEY,String.class),body.get(DEVICE_ID_DATA_KEY,String.class));

        } catch (JwtException exception) {
            //log this jwt error
            log.error("An error occurred during parsing a user identifier",exception);
           // throw exception;
            throw new TokenException("An error occurred during parsing a user identifier",exception);
        }
    }


    //method check signature of the token according to key and return token body
    private Claims parseTokenBody(String token, String key){

        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

    }
}

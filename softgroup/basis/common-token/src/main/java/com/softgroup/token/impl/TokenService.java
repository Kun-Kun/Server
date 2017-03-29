package com.softgroup.token.impl;

import com.softgroup.token.api.JwtUserIdentifier;
import com.softgroup.token.api.TokenGeneratorService;
import com.softgroup.token.api.TokenType;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

import static com.softgroup.token.api.TokenType.*;

/**
 * Created by user on 17.03.2017.
 */


@Service
public class TokenService implements TokenGeneratorService {

    private KeyFactory keyFactory = new KeyFactory();

    //Long term token lifetime in month
    private int longTermTokenLifetime = 12;
    //Short term token lifetime in minute
    private int shortTermTokenLifetime = 10;

    public String createLongTermToken(String deviceId, String userId) {
        if (deviceId == null || userId == null)
            throw new IllegalArgumentException("Device ID or user ID cannot be null. ");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, longTermTokenLifetime);
        JwtBuilder jwtBuilder = Jwts.builder();
        Claims tokenData = Jwts.claims()
                .setExpiration(calendar.getTime())
                .setIssuedAt(new Date());
        tokenData.put("tokenType", LONG_TERM);
        tokenData.put("userID", userId);
        tokenData.put("deviceID", deviceId);
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyFactory.getKey(LONG_TERM)).compact();
    }

    public String createShortTermToken(String token) {
        try {
            //validate token
            validateToken(token,LONG_TERM);

            //Parse token
            Jws<Claims> jws = parseTokenBody(token,keyFactory.getKey(LONG_TERM));

            //token can be generated only from long term token
            if(jws.getBody().get("tokenType").equals(SHORT_TERM.name())){
                throw new JwtException("Token can be generated only from long term token");
            }

            //get body and replace date with new value
            Claims body = jws.getBody();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, shortTermTokenLifetime);
            body.replace("tokenType", SHORT_TERM);
            body.setIssuedAt(new Date());
            body.setExpiration(calendar.getTime());

            //generate new token
            JwtBuilder jwtBuilder = Jwts.builder();
            jwtBuilder.setExpiration(calendar.getTime());
            jwtBuilder.setClaims(body);

            return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyFactory.getKey(SHORT_TERM)).compact();

        } catch (JwtException exception) {
            //log this jwt error
            exception.printStackTrace();
            // throw exception;
            return null;
        }
    }


    public boolean validateToken(String token,TokenType type) {
        return getUserIdentifier(token,type)!=null;
    }

    @Override
    public JwtUserIdentifier getUserIdentifier(String token, TokenType type) {
        //Parse and validate token
        try {
            if(token==null){
                throw new IllegalArgumentException("Token cannot be null. ");
            }

            Jws<Claims> jws = parseTokenBody(token,keyFactory.getKey(type));

            if(jws.getBody().getIssuedAt().after(new Date())){
                throw new JwtException("Error.This token created in future");
            }

            return new JwtUserIdentifier(jws.getBody().get("userID",String.class),jws.getBody().get("deviceID",String.class));

        } catch (JwtException exception) {
            //log this jwt error
            exception.printStackTrace();
           // throw exception;
            return null;
        }
    }


    //method check signature of the token according to key and return token body
    private Jws<Claims> parseTokenBody(String token, String key){

        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);

    }
}

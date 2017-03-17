package com.softgroup.token.impl;

import com.sofrgroup.token.api.TokenGeneratorService;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 17.03.2017.
 */

@Service
public class TokenService implements TokenGeneratorService {
    //key for long term token
    private String keyLT = "kHv4PXv0OiM4V9U0mgwXD58Mq8ooVZJ9";
    //key for short term token
    private String keyST = "AMVvu8OMlipxmr8l73Eo9NXlA5AVNJr1";
    //Long term token lifetime in month
    private int lifetimeTokenLT = 12;
    //Short term token lifetime in minute
    private int lifetimeTokenST = 10;

    public String createToken(String deviceId, String userId) {
        if (deviceId == null || userId == null)
            return null;
        Map<String, Object> tokenData = new HashMap<>();

        tokenData.put("tokenType", "longTerm");
        tokenData.put("userID", userId);
        tokenData.put("deviceID", deviceId);
        tokenData.put("createDate", new Date().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, lifetimeTokenLT);
        tokenData.put("expirationDate", calendar.getTime());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);

        return jwtBuilder.signWith(SignatureAlgorithm.RS256, keyLT).compact();
    }

    public String createTempToken(String token) {
        //validate token
        if (token == null||!validateToken(token))
            return null;
        //Parse token
        Jwt<Header,Claims> jws = Jwts.parser().parseClaimsJwt(token);

        //token can be generated only from long term token
        if(jws.getHeader().get("tokenType").equals("shortTerm")){
            return null;
        }

        //get body and replace date with new value
        Claims body = jws.getBody();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, lifetimeTokenST);
        body.replace("tokenType", "shortTerm");
        body.replace("createDate", new Date().getTime());
        body.replace("expirationDate", calendar.getTime());

        //generate new token
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(body);

        return jwtBuilder.signWith(SignatureAlgorithm.RS256, keyST).compact();
    }


    public boolean validateToken(String token) {
        //Parse token
        Jwt<Header,Claims> jws = Jwts.parser().parseClaimsJwt(token);
        //Validate expiration date
        if(jws.getBody().getExpiration().before(new Date())){
            return false;
        }
        //parse type of token and validate signature
        switch ((String)jws.getHeader().get("tokenType")){
            case "longTerm":
                return validateTokenSignature(token, keyLT);
            case "shortTerm":
                return validateTokenSignature(token, keyST);
        }
        return false;
    }


    //method check signature of the token according to key
    private boolean validateTokenSignature(String token,String key) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            return false;
        }
    }
}

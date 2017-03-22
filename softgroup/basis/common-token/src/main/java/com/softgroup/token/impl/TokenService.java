package com.softgroup.token.impl;

import com.softgroup.token.api.JwtUserIdentifier;
import com.softgroup.token.api.TokenGeneratorService;
import com.softgroup.token.api.TokenType;
import com.softgroup.token.api.UserIdentifier;
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
    private int lifetimeTokenLT = 12;
    //Short term token lifetime in minute
    private int lifetimeTokenST = 10;

    public String createLTToken(String deviceId, String userId) {
        if (deviceId == null || userId == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, lifetimeTokenLT);
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

    public String createSTToken(String token) {
        //validate token
        if (token == null||!validateToken(token,LONG_TERM))
            return null;
        //Parse token
        Jws<Claims> jws = parseTokenBody(token,keyFactory.getKey(LONG_TERM));

        if(jws==null){
            return null;
        }
        //token can be generated only from long term token
        if(jws.getBody().get("tokenType").equals(SHORT_TERM.name())){
            return null;
        }

        //get body and replace date with new value
        Claims body = jws.getBody();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, lifetimeTokenST);
        body.replace("tokenType", SHORT_TERM);
        body.setIssuedAt(new Date());
        body.setExpiration(calendar.getTime());

        //generate new token
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(body);

        return jwtBuilder.signWith(SignatureAlgorithm.HS512, keyFactory.getKey(SHORT_TERM)).compact();
    }


    public boolean validateToken(String token,TokenType type) {
        return getUserIdentifier(token,type)!=null;
    }

    @Override
    public JwtUserIdentifier getUserIdentifier(String token, TokenType type) {
        //Parse and validate token

        if(token==null){
            return null;
        }

        Jws<Claims> jws = parseTokenBody(token,keyFactory.getKey(type));

        if(jws==null){
            return null;
        }

        //Validate expiration date
        if(jws.getBody().getExpiration().before(new Date())){
            return null;
        }

        if(jws.getBody().getIssuedAt().after(new Date())){
            return null;
        }

        //parse type of token

        if (!jws.getBody().get("tokenType").equals(type.name())){
            return null;
        }

        return new JwtUserIdentifier(jws.getBody().get("userID",String.class),jws.getBody().get("deviceID",String.class));
    }


    //method check signature of the token according to key and return token body
    private Jws<Claims> parseTokenBody(String token, String key){
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token);

        } catch (SignatureException se) {
            //log this signature error
            se.printStackTrace();
            return null;
        }
        catch (ExpiredJwtException eje){
            //log this token date not valid
            eje.printStackTrace();
            return null;
        }
        catch (MalformedJwtException mje){
            //log this parsing key error
            mje.printStackTrace();
            return null;
        }
    }
}

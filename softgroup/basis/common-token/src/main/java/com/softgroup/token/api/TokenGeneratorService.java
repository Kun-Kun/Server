package com.softgroup.token.api;

/**
 * Created by user on 17.03.2017.
 */
public interface TokenGeneratorService {

    String createLongTermToken(String deviceId, String userId);

    String createShortTermToken(String token);

    boolean validateToken(String token,TokenType type);

    JwtUserIdentifier getUserIdentifier(String token,TokenType type);
}

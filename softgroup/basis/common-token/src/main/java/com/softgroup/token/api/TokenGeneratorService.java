package com.softgroup.token.api;

/**
 * Created by user on 17.03.2017.
 */
public interface TokenGeneratorService {

    String createLTToken(String deviceId, String userId);
    String createSTToken(String token);
    boolean validateToken(String token,TokenType type);
    UserIdentifier getUserIdentifier(String token,TokenType type);
}

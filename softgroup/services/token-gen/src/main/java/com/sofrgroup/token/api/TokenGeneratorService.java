package com.sofrgroup.token.api;

/**
 * Created by user on 17.03.2017.
 */
public interface TokenGeneratorService {

    String createToken(String deviceId, String userId);
    String createTempToken(String token);
    boolean validateToken(String token);
}

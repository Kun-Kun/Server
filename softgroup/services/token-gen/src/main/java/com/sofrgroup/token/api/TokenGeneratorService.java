package com.sofrgroup.token.api;

/**
 * Created by user on 17.03.2017.
 */
public interface TokenGeneratorService {

    String createLTToken(String deviceId, String userId);
    String createSTToken(String token);
    boolean validateLTToken(String token);
    boolean validateSTToken(String token);
}

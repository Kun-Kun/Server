package com.softgroup.token.api;

import java.util.Date;

/**
 * Created by user on 06.10.2017.
 */
public class JwtUserIdentifierExtended extends JwtUserIdentifier {

    private Date issuedAt;
    private Date expiration;

    public JwtUserIdentifierExtended(String userId, String deviceId, Date issuedAt, Date expiration) {
        super(userId, deviceId);
        this.issuedAt = issuedAt;
        this.expiration = expiration;
    }

    public JwtUserIdentifierExtended(String userId, String deviceId) {
        super(userId, deviceId);
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}

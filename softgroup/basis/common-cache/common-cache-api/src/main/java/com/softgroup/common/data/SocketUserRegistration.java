package com.softgroup.common.data;

import com.softgroup.token.api.JwtUserIdentifierExtended;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by user on 16.10.2017.
 */
public class SocketUserRegistration {

    private JwtUserIdentifierExtended userIdentifier;

    private WebSocketSession session;

    public SocketUserRegistration(JwtUserIdentifierExtended userIdentifier, WebSocketSession session) {
        this.userIdentifier = userIdentifier;
        this.session = session;
    }

    public JwtUserIdentifierExtended getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(JwtUserIdentifierExtended userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }
}

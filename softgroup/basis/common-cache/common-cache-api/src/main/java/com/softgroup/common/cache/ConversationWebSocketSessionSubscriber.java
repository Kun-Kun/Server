package com.softgroup.common.cache;

import com.softgroup.common.data.SocketUserRegistration;
import com.softgroup.token.api.JwtUserIdentifierExtended;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by user on 31.10.2017.
 */
public interface ConversationWebSocketSessionSubscriber {

    void subscribe(SocketUserRegistration registration);

    void unsubscribe(SocketUserRegistration registration);

    void unsubscribe(WebSocketSession session, JwtUserIdentifierExtended jwtUserIdentifierExtended);

    void conversationMembersChanged(String conversationId);


}

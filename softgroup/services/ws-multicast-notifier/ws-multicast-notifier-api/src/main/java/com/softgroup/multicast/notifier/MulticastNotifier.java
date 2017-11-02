package com.softgroup.multicast.notifier;

import com.softgroup.common.protocol.Response;

/**
 * Created by user on 28.10.2017.
 */
public interface MulticastNotifier {
    
    void sendResponseToConversationMembers(String conversationId, Response response);
}

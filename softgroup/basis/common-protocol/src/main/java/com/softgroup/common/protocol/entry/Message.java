package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class Message {
    //ключ
    private String id;
    //id отправителя
    private String sender_id;
    //id Conversation
    private String conversation_id;
    //Тип сообщения
    private Integer message_type;
    //текст сообщения
    private String payload;
    //состояние (выдаётся сервером)
    private Integer status;
    //создание на клиенте
    private Long create_time;
    //время получения сервером
    private Long server_receive_time;
    //индекс сообщения
    private Long message_index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public Integer getMessage_type() {
        return message_type;
    }

    public void setMessage_type(Integer message_type) {
        this.message_type = message_type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getServer_receive_time() {
        return server_receive_time;
    }

    public void setServer_receive_time(Long server_receive_time) {
        this.server_receive_time = server_receive_time;
    }

    public Long getMessage_index() {
        return message_index;
    }

    public void setMessage_index(Long message_index) {
        this.message_index = message_index;
    }
}

package com.softgroup.common.protocol.entry.DTO;

import com.softgroup.common.protocol.entry.Message;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class ConversationFullDTO {

    //id конверсейшна
    private String id;
    //Сообщения
    private ArrayList<Message> messages;
    //Количество непрочитанных
    private Long	total_unread;
    //Существует ли конверсейшн
    private Boolean	exists;
    //Имя
    private String name;
    //Ссылка на логотип чата
    private String	logo_image_uri;
    //тип (0-индивидуальный, 1-групповой)
    private Integer	type;
    //индекс последнего сообщения
    private Long	last_message_index;
    //список ИД пользователей
    private ArrayList<String> members_ids;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public Long getTotal_unread() {
        return total_unread;
    }

    public void setTotal_unread(Long total_unread) {
        this.total_unread = total_unread;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo_image_uri() {
        return logo_image_uri;
    }

    public void setLogo_image_uri(String logo_image_uri) {
        this.logo_image_uri = logo_image_uri;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getLast_message_index() {
        return last_message_index;
    }

    public void setLast_message_index(Long last_message_index) {
        this.last_message_index = last_message_index;
    }

    public ArrayList<String> getMembers_ids() {
        return members_ids;
    }

    public void setMembers_ids(ArrayList<String> members_ids) {
        this.members_ids = members_ids;
    }




}

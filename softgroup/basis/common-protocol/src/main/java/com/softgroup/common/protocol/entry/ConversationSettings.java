package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class ConversationSettings {
    //Conversation
    private String id;
    //id администратора группы
    private String admin_id;
    //название группы
    private String name;
    //логотип группы назначеный админом
    private String logo_image_uri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
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



}

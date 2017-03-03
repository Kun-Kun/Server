package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class Conversation {
    //ключ
    private String id;
    //имя чата
    private String name;
    //Ссылка на логотип чата либо лого по умолчанию
    private String logo_image_uri;
    //тип (0-индивидуальный, 1-групповой)
    private Integer type;
    //индекс последнего сообщения
    private Long last_message_index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}

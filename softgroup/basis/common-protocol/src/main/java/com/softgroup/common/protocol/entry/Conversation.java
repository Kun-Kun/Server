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
    private String logoImageUri;
    //тип (0-индивидуальный, 1-групповой)
    private Integer type;
    //индекс последнего сообщения
    private Long lastMessageIndex;

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

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getLastMessageIndex() {
        return lastMessageIndex;
    }

    public void setLastMessageIndex(Long lastMessageIndex) {
        this.lastMessageIndex = lastMessageIndex;
    }
}

package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class Profile {
    //ключ
    private	String	id;
    //полный номер телефона
    private	String phoneNumber;
    //дата регистрации
    private	Long createDateTime;
    //дата изменения
    private	Long updateDateTime;
    //ссылка на аватар пользователя
    private	String avatarUri;
    //имя пользователя
    private	String	name;
    ///я на море
    private	String	status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

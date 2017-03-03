package com.softgroup.common.protocol.entry;

/**
 * Created by user on 26.02.2017.
 */
public class Profile {
    //ключ
    private	String	id;
    //полный номер телефона
    private	String	phone_number;
    //дата регистрации
    private	Long	create_date_time;
    //дата изменения
    private	Long	update_date_time;
    //ссылка на аватар пользователя
    private	String	avatar_uri;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Long getCreate_date_time() {
        return create_date_time;
    }

    public void setCreate_date_time(Long create_date_time) {
        this.create_date_time = create_date_time;
    }

    public Long getUpdate_date_time() {
        return update_date_time;
    }

    public void setUpdate_date_time(Long update_date_time) {
        this.update_date_time = update_date_time;
    }

    public String getAvatar_uri() {
        return avatar_uri;
    }

    public void setAvatar_uri(String avatar_uri) {
        this.avatar_uri = avatar_uri;
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

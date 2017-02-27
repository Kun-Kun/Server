package com.softgroup.common.protocol;

import java.io.Serializable;

public class Action<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 3373910816445037302L;

    private ActionHeader header;

    private T data;

    public ActionHeader getHeader() {
        return header;
    }

    public void setHeader(ActionHeader header) {
        this.header = header;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

package com.softgroup.common.protocol.DTO;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOCursorRequest implements Serializable {

    private static final long serialVersionUID = 5066285924317357195L;
    //amount
    private	Integer	count;
    //messages offset
    private	Integer	offset;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}

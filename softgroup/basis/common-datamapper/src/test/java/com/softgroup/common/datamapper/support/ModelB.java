package com.softgroup.common.datamapper.support;

import java.util.List;

/**
 * @author odin
 * @since 15.02.17.
 */
public class ModelB<T> {
    private String id;
    private List<T> list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}

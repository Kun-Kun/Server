package com.softgroup.filter.impl;

import com.sofrgroup.router.type.api.TypeRouterHandler;
import com.softgroup.common.filter.api.AbstractCommandFilterHandler;
import com.softgroup.common.filter.api.FilterAction;

import java.util.List;

/**
 * Created by user on 10.04.2017.
 */
public class DenyRequestBorderFilter extends AbstractCommandFilterHandler<TypeRouterHandler> {

    public DenyRequestBorderFilter() {
        List<String> list = getAccessList();
        list.add("register");
        list.add("sms_confirm");
        list.add("login");
    }

    @Override
    public String getName() {
        return "DenyRequestBorderFilter";
    }

    @Override
    public FilterAction getAction() {
        return FilterAction.DENY;
    }
}

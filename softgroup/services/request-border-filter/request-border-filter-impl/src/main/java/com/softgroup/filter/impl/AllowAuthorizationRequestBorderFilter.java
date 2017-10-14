package com.softgroup.filter.impl;

import com.sofrgroup.router.type.api.TypeRouterHandler;
import com.softgroup.common.filter.api.AbstractCommandFilterHandler;
import com.softgroup.common.filter.api.FilterAction;

import com.softgroup.filter.api.AllowAuthorizationRequestBorderFilterHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 10.04.2017.
 */
@Component
public class AllowAuthorizationRequestBorderFilter extends AbstractCommandFilterHandler<TypeRouterHandler> implements AllowAuthorizationRequestBorderFilterHandler {

    public AllowAuthorizationRequestBorderFilter() {
        List<String> list = getAccessList();
        list.add("register");
        list.add("sms_confirm");
        list.add("login");
    }

    @Override
    public String getName() {
        return "AllowRequestBorderFilter";
    }

    @Override
    public FilterAction getAction() {
        return FilterAction.ALLOW;
    }

    @Override
    protected String getMessageOnFilter() {
        return "You not authorized. Allowed only register, sms_confirm, login commands.";
    }
}

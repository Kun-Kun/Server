package com.softgroup.common.filter.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10.04.2017.
 */
public abstract class AbstractFilterHandler<T extends Handler> implements RequestFilterHandler{

    @Autowired
    private T handler;

    private List<String> accessList = new ArrayList<>();

    public List<String> getAccessList() {
        return accessList;
    }

    public void setAccessList(List<String> accessList) {
        this.accessList = accessList;
    }

    public abstract FilterAction getAction();

    @Override
    public Response<?> handle(Request<?> msg) {
        try {
            if (accessList.contains(getFilteredValue(msg))) {
                return triggeredRuleAction(msg);
            } else {
                return notTriggeredRuleAction(msg);
            }
        }catch (NullPointerException npe){
            npe.printStackTrace();
            return ResponseUtils.createCustomResponse(new Request<>(), ResponseStatusCode.UNPROCESSABLE_ENTITY,"Entity can't be null");
        }
    }

    protected abstract String getFilteredValue(Request<?> msg);

    private Response<?> triggeredRuleAction(Request<?> msg){
        if(getAction().equals(FilterAction.ALLOW)){
            return doHandle(msg);
        }else
            return ResponseUtils.createCustomResponse(msg, ResponseStatusCode.FORBIDDEN,getMessageOnFilter());
    }

    private Response<?> notTriggeredRuleAction(Request<?> msg){
        if(getAction().equals(FilterAction.ALLOW)){
            return ResponseUtils.createCustomResponse(msg, ResponseStatusCode.FORBIDDEN,getMessageOnFilter());
        }else
            return doHandle(msg);
    }

    private Response<?> doHandle(Request<?> msg) {
        return handler.handle(msg);
    }

    protected abstract String getMessageOnFilter();
}

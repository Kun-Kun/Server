package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.profile.api.message.dto.DTOContact;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class ContactsSyncRequestHandler extends AbstractRequestHandler<ContactsSyncRequest,ContactsSyncResponse> implements ProfileRequestHandler{

    @Autowired
    private ProfileService profileService;

    @Override
    public String getName(){
        return "contacts_sync";
    }

    @Override
    public Class<ContactsSyncRequest> getRequestDataClass() {
        return ContactsSyncRequest.class;
    }

    public Response<ContactsSyncResponse> processRequest(Request<ContactsSyncRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        List<DTOContact> added =  msg.getData().getAddedContact();
        List<DTOContact> deleted = msg.getData().getRemovedContact();
        if(deleted!=null) {
            deleted.forEach(dtoContact -> {
                List<String> validList = dtoContact.getPhoneNumber().stream().filter(s -> checkPhoneNumber(s)).collect(Collectors.toList());
                profileService.removePhoneNumbers(userId, dtoContact.getName(), validList);
            });
        }
        if(added!=null) {
            added.forEach(dtoContact -> {
                List<String> validList = dtoContact.getPhoneNumber().stream().filter(s -> checkPhoneNumber(s)).collect(Collectors.toList());
                profileService.addPhoneNumbers(userId, dtoContact.getName(), validList);
            });
        }
        return ResponseUtils.createOKResponse(msg,new ContactsSyncResponse());
    }

    //Todo make one method (another in auth service)
    private Boolean checkPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^\\+[0-9]{12}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}

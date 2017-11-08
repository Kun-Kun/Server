package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.OtherUtils;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.common.dto.DTOContact;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


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
        if(checkNumbers(added)&&checkNumbers(deleted)){
            if(deleted!=null) {
                deleted.forEach(dtoContact -> {
                    profileService.removePhoneNumbers(userId, dtoContact.getName(), dtoContact.getPhoneNumber());
                });
            }
            if(added!=null) {
                added.forEach(dtoContact -> {
                    profileService.addPhoneNumbers(userId, dtoContact.getName(), dtoContact.getPhoneNumber());
                });
            }
            return ResponseUtils.createOKResponse(msg,new ContactsSyncResponse());
        }else return ResponseUtils.createCustomResponse(msg, ResponseStatusCode.UNPROCESSABLE_ENTITY,"Bad phone number format");
    }

    private Boolean checkNumbers(List<DTOContact> contacts){
        if(contacts!=null) {
            return contacts.stream().allMatch(dtoContact ->
                dtoContact.getPhoneNumber().stream().allMatch(s -> OtherUtils.checkPhoneNumber(s))
            );
        }else return true;
    }

}

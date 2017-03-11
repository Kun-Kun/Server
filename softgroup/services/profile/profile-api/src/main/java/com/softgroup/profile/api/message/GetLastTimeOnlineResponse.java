package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.DTO.DTOProfileStatus;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetLastTimeOnlineResponse  implements ResponseData {

    private ArrayList<DTOProfileStatus> profiles;
}

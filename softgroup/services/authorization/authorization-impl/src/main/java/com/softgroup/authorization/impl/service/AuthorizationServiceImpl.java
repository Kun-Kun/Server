package com.softgroup.authorization.impl.service;

import com.softgroup.authorization.api.cache.ConfirmationRegisterCache;
import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.cache.PhoneNumberUUIDCache;
import com.softgroup.authorization.api.cache.SmsQuantityLimiterCache;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.SmsConfirmRequest;
import com.softgroup.authorization.api.service.AuthorizationService;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.DeviceRepository;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import com.softgroup.common.sms.SmsService;
import com.softgroup.token.api.TokenGeneratorService;
import com.softgroup.token.api.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 30.07.2017.
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService{

    @Autowired
    private ConfirmationRegisterCache confirmationRegisterCache;

    @Autowired
    private SmsQuantityLimiterCache smsQuantityLimiterCache;

    @Autowired
    private PhoneNumberUUIDCache phoneNumberUUIDCache;

    @Autowired
    private TokenGeneratorService tokenGeneratorService;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private SmsService smsService;

    public Boolean checkPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^\\+[0-9]{12}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public String clearPhoneNumber(String phoneNumber){
        return phoneNumber.replaceAll("[- )(]","");
    }

    //Now only available only Ukrainian locale
    public Boolean checkLocaleCode(String locale){
        return "uk_UA".equals(locale);
    }

    public boolean isPhoneNumberInQuantityLimiter(String phone){
        return smsQuantityLimiterCache.isInDatabase(phone);
    }

    public void addDataToConfirmationRegisterCache(ConfirmationRegisterData data){
        confirmationRegisterCache.put(data.getRegistrationRequestUUID(),data);
        String phoneNumber = clearPhoneNumber(data.getRequest().getPhoneNumber());
        phoneNumberUUIDCache.put(phoneNumber,data.getRegistrationRequestUUID());
    }

    public void addPhoneNumberToSmsQuantityLimiterCache(String phone,String registrationRequestUUID){
        smsQuantityLimiterCache.put(phone,registrationRequestUUID);
    }

    public String getUUIDFromPhone(String phoneNumber){
        return phoneNumberUUIDCache.get(phoneNumber);
    }

    //Return ConfirmationRegisterData if present in cache, else return null
    public ConfirmationRegisterData getRegisterDataFromPhoneNumber(String phoneNumber){
        String uuid = getUUIDFromPhone(phoneNumber);
        if (uuid==null){
            return null;
        }
        return confirmationRegisterCache.get(uuid);
    }

    public Integer calculateRegistrationTimeout(ConfirmationRegisterData data){
        Long requestTime = new Date().getTime();
        Long timeToTimeout = confirmationRegisterCache.getTimeoutTime();
        Long timeoutMs = data.getCreateTime()+timeToTimeout-requestTime;
        return (int)TimeUnit.MILLISECONDS.toSeconds(timeoutMs);
    }

    public Boolean checkVerificationCode(String registrationRequestUUID, String confirmationCode){
        ConfirmationRegisterData confirmationRegisterData = confirmationRegisterCache.get(registrationRequestUUID);
        return confirmationRegisterData!=null && confirmationCode.equals(confirmationRegisterData.getConfirmationCode());
    }

    public RegisterRequest popRecordFromCache(String registrationRequestUUID){
        RegisterRequest registerRequest = confirmationRegisterCache.pop(registrationRequestUUID).getRequest();
        String phoneNumber = registerRequest.getPhoneNumber();
        phoneNumberUUIDCache.invalidate(phoneNumber);
        return registerRequest;
    }

    public String createProfileIfNotExist(String phoneNumber, String locale){
        ProfileEntity profileEntity = profileRepository.findByPhoneNumber(phoneNumber);
        if (profileEntity != null){
            return profileEntity.getId();
        }else{
            return createProfile(phoneNumber,locale);
        }
    }

    public String createDeviceIfNotExist(String profileId, String deviceId){
        DeviceEntity deviceEntity = deviceRepository.findFirstByUserIdAndDeviceId(profileId,deviceId);
        if(deviceEntity != null){
            updateLastConfirm(deviceEntity);
            return deviceEntity.getId();
        }else {
            return createDevice(profileId, deviceId);
        }
    }


    private String createProfile(String phoneNumber, String locale){
        Long timestamp = new Date().getTime();
        ProfileEntity entity = new ProfileEntity();
        entity.setCreateDateTime(timestamp);
        entity.setUpdateDateTime(timestamp);
        entity.setLastTimeOnline(timestamp);
        entity.setLocale(locale);
        entity.setPhoneNumber(phoneNumber);
        entity.setName(phoneNumber);
        entity.setAvatarUri("/avatar/default_profile.jpg");
        ProfileEntity entityInDatabase = profileRepository.save(entity);
        return entityInDatabase.getId();
    }

    private String createDevice(String userId, String deviceId){
        Long timestamp = new Date().getTime();
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setUserId(userId);
        deviceEntity.setDeviceId(deviceId);
        deviceEntity.setLastConfirm(timestamp);
        DeviceEntity entityInDatabase = deviceRepository.save(deviceEntity);
        return entityInDatabase.getId();
    }

    private void updateLastConfirm(DeviceEntity deviceEntity){
        deviceEntity.setLastConfirm(new Date().getTime());
        deviceRepository.save(deviceEntity);
    }

    public String generateDeviceToken(String profileId, String deviceId){
        return tokenGeneratorService.createLongTermToken(deviceId, profileId);
    }

    public String generateToken(String deviceToken){
        return tokenGeneratorService.createShortTermToken(deviceToken);
    }

    public Boolean validateDeviceToken(String deviceToken){
        return tokenGeneratorService.validateToken(deviceToken,TokenType.LONG_TERM);
    }

}

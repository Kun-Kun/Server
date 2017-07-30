package com.softgroup.common.sms;

import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 14.04.2017.
 */
public class AndroidSmsGatewayApp implements SmsService{

    private Log log = LogFactory.getLog(AndroidSmsGatewayApp.class);

    @Override
    public void send(String number, String message) {

        try {
            String USER_AGENT = "Mozilla/5.0";
            String url = "http://192.168.1.3:9090/sendsms?password=1&phone="+number+"&text="+message;
            URL obj = new URL(URIUtil.encodeQuery(url));
            log.info(obj.toExternalForm());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            log.info("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                log.info(response.toString());
            } else {
                log.info("GET request not worked");
            }
        }catch (IOException e){
            log.error("Cannot send sms ",e);
        }

    }
}

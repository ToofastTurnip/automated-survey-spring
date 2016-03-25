package com.twilio.survey.controllers;

import com.mashape.unirest.http.Unirest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic Unirest and general test helpers
 */
public class BaseControllerTest {
    @Value("${local.server.port}")
    int port;
    @Before
    public void baseBefore(){
        //Clean up cookies and use a cookie manager
        BasicCookieStore cookieStore = new BasicCookieStore();
        Unirest.setHttpClient(HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build());
    }

    protected String getAsSMS(String url) throws Exception {
        return getWithParameters(url, "MessageSid", "SMS225345234234");
    }

    protected String getAsCall(String url) throws Exception {
        return getWithParameters(url, "CallSid", "Call25345234234");
    }

    protected String getWithParameters(String url, String key, String value) throws Exception {
        url = "http://localhost:" + port + url;
                Map<String, Object> params = new HashMap<>();
        params.put(key, value);
        String stringResponse = Unirest.get(url).queryString(params).asString().getBody();

        return stringResponse;
    }
}
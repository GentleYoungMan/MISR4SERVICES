package com.msir.web;

import com.msir.pojo.UserDO;
import com.msir.utils.GlobalUtils;
import com.msir.utils.JWT;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by Fantasy on 2017/2/6.
 */
public class TestToken {

    public static final String CHANNEL_APP_KEY = "e797c5d6ccd36ae12f073ca69297c185";

    @Test
    public void TestToken() {
        UserDO user = new UserDO();
        user.setId(1);
        user.setUserName("ss");
        user.setUserPassword("123456");
        String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
        System.out.println(token);
    }

    @Test
    public void getHttps() throws IOException, URISyntaxException {
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("japi.juhe.cn")
                .setPath("/tv/getCategory")
                .setParameter("key", CHANNEL_APP_KEY)
                .build();
        System.out.println(GlobalUtils.httpsManager4get(uri));

    }
}

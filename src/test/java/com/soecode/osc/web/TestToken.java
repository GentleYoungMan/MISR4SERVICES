package com.soecode.osc.web;

import com.soecode.osc.entity.User;
import com.soecode.osc.utils.JWT;
import org.junit.Test;

/**
 * Created by Fantasy on 2017/2/6.
 *
 */
public class TestToken {

    @Test
    public  void TestToken() {
        User user = new User();
        user.setId(1);
        user.setUserName("ss");
        user.setPassword("123456");
        String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
        System.out.println(token);
    }
}

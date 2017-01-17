package com.soecode.lyf.web;

import com.soecode.lyf.entity.User;
import com.soecode.lyf.utils.JWT;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * token
 */
public class TokenController {
    private Logger log = Logger.getLogger(TokenController.class);

    /**
     * 生成token
     */
    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request) {
        if ("ss".equals(username) && "123456".equals(password)) {
            User user = new User();
            user.setId(1);
            user.setUsername(username);
            user.setPassword(password);
            String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);
            log.info("token:::"+token);
            request.setAttribute("token",token);
        }

        return "login";
    }
}

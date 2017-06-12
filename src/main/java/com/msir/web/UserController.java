package com.msir.web;

import com.alibaba.fastjson.JSON;
import com.msir.enums.MenuStateEnum;
import com.msir.pojo.MenuDO;
import com.msir.pojo.TokenDO;
import com.msir.pojo.UserDO;
import com.msir.service.UserService;
import com.msir.utils.Constant;
import com.msir.utils.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Fantasy on 2017/6/8.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
    public Object userLogin(UserDO userDO, HttpServletResponse resp) {
        UserDO fetchUserDO = userService.getUserInfo(userDO.getUserLoginName());
        if (null != fetchUserDO && userDO.getUserPassword().equals(fetchUserDO.getUserPassword())) {
            TokenDO token = new TokenDO();
            String userJsonStr = JSON.toJSON(fetchUserDO).toString();
            String JWTtoken = JWT.createJWT(Constant.JWT_ID, userJsonStr, Constant.JWT_TTL);
            token.setToken(JWTtoken);
            token.setUserID(fetchUserDO.getUserId());
            return JSON.toJSON(token);
        }
        FinalResult finalResult = new FinalResult<String>(
                true,
                "",
                "查询成功",
                "登录失败",
                "707010");
        return JSON.toJSON(finalResult);
    }
}

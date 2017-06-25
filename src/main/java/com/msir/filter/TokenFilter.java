package com.msir.filter;


import com.alibaba.fastjson.JSON;
import com.msir.pojo.UserDO;
import com.msir.utils.JWT;
import com.msir.web.UserController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fantasy on 2017/6/13.
 * token过滤
 */
public class TokenFilter extends OncePerRequestFilter {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        try {
            String accessToken = req.getHeader("access-token");
            if (accessToken != null && !"".equals(accessToken)) {
                Claims claimsToken = JWT.parseJWT(accessToken);
                UserDO userDO = JSON.parseObject(claimsToken.getSubject(), UserDO.class);
                if (UserController.getUserIdCache() == userDO.getUserId()) {
                    filterChain.doFilter(req, resp);
                    return;
                } else {
                    resp.setStatus(resp.SC_UNAUTHORIZED);
                }
                resp.setStatus(resp.SC_UNAUTHORIZED);
            }
        } catch (IOException e) {
            logger.error("过滤器异常", e);
            throw e;
        } catch (ServletException e) {
            logger.error("过滤器异常", e);
            throw e;
        } catch (ExpiredJwtException e) {
            logger.error("ExpiredJwtException", e);
            resp.setStatus(resp.SC_REQUEST_TIMEOUT);
            filterChain.doFilter(req, resp);
        }
    }
}

package com.example.testjob.common;

import com.example.testjob.model.entity.UserSessionEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieFunction {


    public void addTokenToBrowser(HttpServletRequest request, HttpServletResponse response, UserSessionEntity newUserToken) {
        Cookie newTokenUser = new Cookie("USERSESSIONID",newUserToken.getToken());
        newTokenUser.setPath("/");
        newTokenUser.setHttpOnly(true);
        newTokenUser.setMaxAge(43000);
        response.addCookie(newTokenUser);
    }
}

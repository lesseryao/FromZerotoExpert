package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注解为@Controller（返回页面），@RestController为返回json
 */
@Controller

public class FromZerotoExpert {
    @ResponseBody
    @RequestMapping("/FromZerotoExpert")
    public String test(HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie myCookie = null;
        //判断cookie是否指向为空指针
        if (cookies != null){
            //遍历cookies，找到对应的cookie
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("yhz") && cookie.getValue().equals("1")){
                    myCookie = cookie;
                    break;
                }
            }
        }
        if (myCookie != null){
            return "嗨，欢迎您再次到 from zero to expert.";
        } else {
            Cookie newCookie = new Cookie("yhz","1");
            newCookie.setMaxAge(24 * 60 * 60);
            response.addCookie(newCookie);
            return "嗨，欢迎您来到 from zero to expert.";
        }
    }
}

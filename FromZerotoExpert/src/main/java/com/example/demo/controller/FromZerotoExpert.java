package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解为@Controller（返回页面），@RestController为返回json
 */
@Controller

public class FromZerotoExpert {
    @RequestMapping("/FromZerotoExpert")
    public String test(){
        return "welcome"; }
}

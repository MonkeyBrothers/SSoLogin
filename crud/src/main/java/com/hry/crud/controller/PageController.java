package com.hry.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制页面跳转
 */
@Controller
@RequestMapping("/crud")
public class PageController {
    @ResponseBody
    @RequestMapping("/index")
    public String main() {
        return "这里表示没有拦截到内容";
    }
}

package com.hry.sso.controller;

import com.hry.sso.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/sso")
public class LoginController {
    @Autowired
    private TokenService tokenService;
    @RequestMapping("/checkLogin")
    public String checkLogin(String redirectUrl, HttpSession session, Model model) {
        // 判断是否有全局会话
        String token = (String) session.getAttribute("token");
        // 没有全局会话
        if (StringUtils.isEmpty(token)) {
            // 跳转到统一认证界面并且保存之前的url地址
            model.addAttribute("redirectUrl", redirectUrl);
            return "login";
        } else {
            // 有全局会话
            return "success";
        }

    }

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @param redirectUrl 重定向的地址
     * @param session session域
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, String redirectUrl, HttpSession session, Model model) {
        // 账号密码匹配
        if ("hry".equals(username) && "123456".equals(password)) {
            // 创建令牌
            String token = UUID.randomUUID().toString();
            // 创建全局会话，把token存入到全局会话中
            session.setAttribute("token", token);
            // 把令牌存入到数据库
            tokenService.addToken(token);
            // 重定向到URL把令牌信息带上
            model.addAttribute("token", token);
            return "redirect:" + redirectUrl;
        } else {
            // 如果账号密码信息有误重新回到登录界面，把redirectURL存入到request域中
            model.addAttribute("redirectUrl", redirectUrl);
            return "login";
        }
    }
}

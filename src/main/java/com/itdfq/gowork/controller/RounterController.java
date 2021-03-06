package com.itdfq.gowork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author GocChin
 * @Date 2021/4/29 11:14
 * @Blog: itdfq.com
 * @QQ: 909256107
 */
@Controller
public class RounterController {
    // 登陆页（首页）
    @GetMapping("/home")
    public String indexHome() {
        return "index";
    }
    // 登陆页（首页）
    @GetMapping("/")
    public String indexPage() {
        return "login";
    }
    // 退出系统
    @RequestMapping("/logout")
    public String administratorLogout(HttpSession session) {
        session.setAttribute("user", null);
//        session.setAttribute("adminName",null);
        return "login";
    }
}

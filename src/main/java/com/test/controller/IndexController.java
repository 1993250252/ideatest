package com.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * @Author:ZhaoMeng
 * @Description:
 * @Date:Created 2022/12/13 18:33
 * @Modified By:
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/toMain")
    public String  toMain(){
        System.out.println("你好");
        return "main";
    }

    @RequestMapping("/toLogin")
    public String  toLogin(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpSession session, String username, String password){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(
                username,password
        );
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println("身份验证失败");
            session.setAttribute("message","身份验证失败");
            return "login";
        }
        session.setAttribute("username",username);
        return "main";
    }

    @RequestMapping("/updateUser")
    @RequiresRoles("admin")
    public String updateUser(){
        return "  ";
    }
}

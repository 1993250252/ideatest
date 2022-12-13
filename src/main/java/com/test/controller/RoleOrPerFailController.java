package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:ZhaoMeng
 * @Description:
 * @Date:Created 2022/12/13 19:16
 * @Modified By:
 */
@Controller
@RequestMapping
public class RoleOrPerFailController {

    @RequestMapping("/abc")
    public String unFail(){
        System.out.println("你好");
        return "unauthorized";
    }
}

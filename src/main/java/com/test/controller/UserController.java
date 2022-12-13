package com.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.model.User;
import com.test.service.IUserService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import com.test.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zm
 * @since 2022-11-24
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public JsonResponseBody list(HttpServletResponse resp,User user){
        JsonResponseBody checked = userService.checked(user);
        Map<String,Object> claims=new HashMap<>();
        claims.put("user",checked.getData());
        String jwt = JwtUtils.createJwt(claims, 1000 * 60);
        resp.setHeader("jwt",jwt);
        return checked;
    }

    @RequestMapping("/insert")
    public JsonResponseBody insert(User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("uname",user.getUname());
        User u = userService.getOne(queryWrapper);
        if(null==u) {
            boolean save = userService.save(user);
            if (true == save) {
                return new JsonResponseBody(JsonResponseStatus.ADD.getCode(), JsonResponseStatus.ADD.getMsg());
            } else {
                return new JsonResponseBody(JsonResponseStatus.ERROR.getCode(), JsonResponseStatus.ERROR.getMsg());
            }
        }else{
            return  new JsonResponseBody(JsonResponseStatus.CZ.getCode(),JsonResponseStatus.CZ.getMsg());
        }
    }

}

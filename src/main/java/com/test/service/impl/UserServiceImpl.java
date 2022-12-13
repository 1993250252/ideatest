package com.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.model.User;
import com.test.mapper.UserMapper;
import com.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zm
 * @since 2022-11-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResponseBody checked(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("uname",user.getUname());
        User u = userMapper.selectOne(queryWrapper);
        if(null==u){
            //账号不存在
            return new JsonResponseBody(JsonResponseStatus.NULLACCOUNT.getCode(),JsonResponseStatus.NULLACCOUNT.getMsg());
        }else{
            if(user.getUpwd().equals(u.getUpwd())){
                return new JsonResponseBody(u);
            }else{
                //密码不正确
                return new JsonResponseBody(JsonResponseStatus.PWDERROR.getCode(),JsonResponseStatus.PWDERROR.getMsg());
            }
        }


    }
}

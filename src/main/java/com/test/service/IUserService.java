package com.test.service;

import com.test.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.test.util.JsonResponseBody;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zm
 * @since 2022-11-24
 */
@Transactional
public interface IUserService extends IService<User> {

    JsonResponseBody checked(User user);

}

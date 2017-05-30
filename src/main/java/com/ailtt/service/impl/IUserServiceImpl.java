package com.ailtt.service.impl;

import com.ailtt.dao.UserMapper;
import com.ailtt.model.User;
import com.ailtt.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pengzhihao on 2017/5/30.
 */
@Service("uservice")
public class IUserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    public void insert(User user) {
        userMapper.insert(user);
    }


}

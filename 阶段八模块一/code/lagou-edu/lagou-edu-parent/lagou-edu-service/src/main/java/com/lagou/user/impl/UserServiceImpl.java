package com.lagou.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.mapper.UserDao;
import com.lagou.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lagou.entity.User;


/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-05-02 09:57:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User login(String phone, String password) {
        return userDao.login(phone,password);
    }

    @Override
    public Integer checkPhone(String phone) {
        return userDao.checkPhone(phone);
    }

    @Override
    public Integer register(String phone, String password) {
        return userDao.register(phone,password);
    }

    @Override
    public Integer updateUserInfo(int id, String portrait, String name) {
        return userDao.updateUserInfo(id, portrait, name);
    }

    @Override
    public Integer updatePassword(int id, String password) {
        return userDao.updatePassword(id, password);
    }
}

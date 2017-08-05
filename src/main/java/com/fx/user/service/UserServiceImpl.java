package com.fx.user.service;

import com.fx.common.utils.SecurityUtils;
import com.fx.user.dao.UserMapper;
import com.fx.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void createUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        userMapper.insertSelective(user);
    }
}

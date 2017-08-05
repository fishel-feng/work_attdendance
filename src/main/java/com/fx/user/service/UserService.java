package com.fx.user.service;

import com.fx.user.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {

    User findUserByUsername(String username);

    void createUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}

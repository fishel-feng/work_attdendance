package com.fx.login.controller;

import com.fx.common.utils.SecurityUtils;
import com.fx.user.entity.User;
import com.fx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String login() {
        return "login";
    }

    @RequestMapping("check")
    @ResponseBody
    public String checkLogin(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findUserByUsername(username);
        if (user != null) {
            if (SecurityUtils.checkPassword(password, user.getPassword())) {
                request.getSession().setAttribute("user", user);
                return "login_success";
            } else {
                return "login_fail";
            }
        } else {
            return "login_fail";
        }
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(@RequestBody User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        userService.createUser(user);
        return "success";
    }
}
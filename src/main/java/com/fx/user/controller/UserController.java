package com.fx.user.controller;

import com.fx.user.entity.User;
import com.fx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("home")
    public String home(){
        return "home";
    }

    @RequestMapping("info")
    @ResponseBody
    public User getUser(HttpSession session){
        return  (User) session.getAttribute("user");
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}

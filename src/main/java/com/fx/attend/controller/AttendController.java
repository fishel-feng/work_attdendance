package com.fx.attend.controller;

import com.fx.attend.entity.Attend;
import com.fx.attend.service.AttendService;
import com.fx.attend.vo.QueryCondition;
import com.fx.common.page.PageQueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("attend")
public class AttendController {

    @Autowired
    private AttendService attendService;

    @RequestMapping
    public String toAttend(){
        return "attend";
    }

    @RequestMapping("sign")
    @ResponseBody
    public String signAttend(@RequestBody Attend attend){
        attendService.signAttend(attend);
        return "success";
    }

    @RequestMapping("attendList")
    @ResponseBody
    public PageQueryBean listAttend(QueryCondition condition){
        PageQueryBean result=attendService.listAttend(condition);
        return result;
    }
}

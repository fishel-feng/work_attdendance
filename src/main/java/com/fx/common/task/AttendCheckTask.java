package com.fx.common.task;

import com.fx.attend.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;

public class AttendCheckTask {

    @Autowired
    private AttendService attendService;

    public void checkAttend(){
        attendService.checkAttend();
    }
}

package com.fx.attend.service;

import com.fx.attend.entity.Attend;
import com.fx.attend.vo.QueryCondition;
import com.fx.common.page.PageQueryBean;

public interface AttendService {

    void signAttend(Attend attend);

    PageQueryBean listAttend(QueryCondition condition);

    void checkAttend();
}

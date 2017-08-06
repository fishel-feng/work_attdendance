package com.fx.attend.service;

import com.fx.attend.dao.AttendMapper;
import com.fx.attend.entity.Attend;
import com.fx.attend.vo.QueryCondition;
import com.fx.common.page.PageQueryBean;
import com.fx.common.utils.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AttendServiceImpl implements AttendService {

    private static final int NOON_HOUR = 12;

    private static final int NOON_MINUTE = 0;

    private Log log = LogFactory.getLog(AttendServiceImpl.class);

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Autowired
    private AttendMapper attendMapper;

    @Override
    public void signAttend(Attend attend) {
        try {
            Date today = new Date();
            attend.setAttendDate(today);
            attend.setAttendWeek((byte) DateUtils.getTodayWeek());
            Attend todayRecord = attendMapper.selectTodaySignRecord(attend.getUserId());
            Date noon = DateUtils.getDate(NOON_HOUR, NOON_MINUTE);
            if (todayRecord == null) {
                if (today.compareTo(noon) <= 0) {
                    attend.setAttendMorning(today);
                } else {
                    attend.setAttendEvening(today);
                }
                attendMapper.insertSelective(attend);
            } else {
                if (today.compareTo(noon) > 0) {
                    todayRecord.setAttendEvening(today);
                    attendMapper.updateByPrimaryKeySelective(todayRecord);
                }
            }
        } catch (Exception e) {
            log.error("用户签到异常", e);
            throw e;
        }
    }

    @Override
    public PageQueryBean listAttend(QueryCondition condition) {
        int count=attendMapper.countByCondition(condition);
        PageQueryBean pageResult=new PageQueryBean();
        if (count>0){
            pageResult.setTotalRows(count);
            pageResult.setCurrentPage(condition.getCurrentPage());
            pageResult.setPageSize(condition.getPageSize());
            List<Attend> attendList=attendMapper.selectAttendPage(condition);
            pageResult.setItems(attendList);
        }
        return pageResult;
    }
}

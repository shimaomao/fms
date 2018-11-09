package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.system.repository.SysLogRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.extend.config.WebProperties;
import cn.com.leadu.fms.extend.pojo.vo.RequestParamsLog;
import cn.com.leadu.fms.extend.service.LogService;
import cn.com.leadu.fms.pojo.system.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaomengnan
 * @ClassName: LogServiceImpl
 * @Description:
 * @date 2018/3/22
 */
@Service
public class LogServiceImpl implements LogService {

    /**
     * @Fields  : 日志管理repository
     */
    @Autowired
    private SysLogRepository sysLogRepository;

    /**
     * @Title:
     * @Description:   请求日志保存
     * @param requestParamsLog
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/22 03:12:28
     */
    @Override
    public void saveLog(RequestParamsLog requestParamsLog) {
        String userName = UserInfoUtils.getUserName();
        if(requestParamsLog != null && StringUtils.isNotTrimBlank(userName)
                && WebProperties.isLog(RequestUtils.getRequestUri())) {
            SysLog sysLog = new SysLog();
            sysLog.setStartTime(requestParamsLog.getStartTime());
            sysLog.setEndTime(requestParamsLog.getEndTime());
            sysLog.setActWidgetId(requestParamsLog.getRequestUrl());
            sysLog.setActParamInfo(requestParamsLog.getRequestParams());
            sysLog.setUser(userName);
            sysLogRepository.insertData(sysLog);
        }
    }

}

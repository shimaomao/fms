package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysLogRepository;
import cn.com.leadu.fms.pojo.system.entity.SysLog;
import cn.com.leadu.fms.pojo.system.vo.syslog.SysLogVo;
import cn.com.leadu.fms.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author qiaomengnan
 * @ClassName: SysLogService
 * @Description: 日志管理业务实现层
 * @date 2018-03-22
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    /**
     * @Fields  : 日志管理repository
     */
    @Autowired
    private SysLogRepository sysLogRepository;

    /**
     * @Title:
     * @Description: 分页查询日志管理
     * @param sysLogVo
     * @return PageInfoExtend<SysLog>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    public PageInfoExtend<SysLog> findSysLogsByPage(SysLogVo sysLogVo){
        Example example = SqlUtil.newExample(SysLog.class);
        Example.Criteria criteria = example.createCriteria();
        //设置查询条件
        if(StringUtils.isNotTrimBlank(sysLogVo.getActWidgetId())){
            criteria.andLike("actWidgetId",SqlUtil.likePattern(sysLogVo.getActWidgetId()));
        }
        if (StringUtils.isNotTrimBlank(sysLogVo.getUser())){
            criteria.andLike("user",SqlUtil.likePattern(sysLogVo.getUser()));
        }

        SqlUtil.setOrderByUpdateTimeDesc(example);
        PageInfoExtend<SysLog> pageInfo = sysLogRepository.selectListByExamplePage(example,sysLogVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存日志管理
     * @param sysLog
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    public void saveSysLog(SysLog sysLog){
        sysLogRepository.insertData(sysLog);
    }

    /**
     * @Title:
     * @Description:  根据logId获取日志管理
     * @param logId
     * @return SysLog
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    public SysLog findSysLogByLogId(String logId){
        return sysLogRepository.selectByPrimaryKey(logId);
    }

}

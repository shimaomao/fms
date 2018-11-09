package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysLog;
import cn.com.leadu.fms.pojo.system.vo.syslog.SysLogVo;

/**
 * @author qiaomengnan
 * @ClassName: SysLogService
 * @Description: 日志管理业务层
 * @date 2018-03-22
 */
public interface SysLogService {

	/**
	 * @Title:
	 * @Description: 分页查询日志管理
	 * @param sysLogVo
	 * @return PageInfoExtend<SysLog>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:45
	 */
	PageInfoExtend<SysLog> findSysLogsByPage(SysLogVo sysLogVo);

	/**
	 * @Title:
	 * @Description: 保存日志管理
	 * @param sysLog
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:45
	 */
    void saveSysLog(SysLog sysLog);



	/**
	 * @Title:
	 * @Description:  根据logId获取日志管理
	 * @param logId
	 * @return SysLog
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:45
	 */
	SysLog findSysLogByLogId(String logId);

}

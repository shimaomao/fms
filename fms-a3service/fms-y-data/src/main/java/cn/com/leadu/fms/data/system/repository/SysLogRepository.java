package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysLog;
import cn.com.leadu.fms.pojo.system.vo.syslog.SysLogVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysLogRepository
 * @Description: 日志管理Repository层
 * @date 2018-03-22
 */
public interface SysLogRepository {

	/**
	 * @Title:
	 * @Description: 新增日志管理
	 * @param sysLog
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int insertData(SysLog sysLog);

	/**
	 * @Title:
	 * @Description: 批量保存日志管理
	 * @param sysLogs
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int insertDataList(List<SysLog> sysLogs);

	/**
	 * @Title:
	 * @Description: 修改日志管理
	 * @param sysLog
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int updateByPrimaryKeyData(SysLog sysLog);

	/**
	 * @Title:
	 * @Description: 批量修改日志管理
	 * @param sysLogs
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int updateByPrimaryKeyDataList(List<SysLog> sysLogs);

	/**
	 * @Title:
	 * @Description: 动态修改日志管理
	 * @param sysLog
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int updateByPrimaryKeySelectiveData(SysLog sysLog);

	/**
	 * @Title:
	 * @Description: 批量动态修改日志管理
	 * @param sysLogs
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysLog> sysLogs);

	/**
	 * @Title:
	 * @Description: 根据条件修改日志管理
	 * @param sysLog
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int updateByExampleData(SysLog sysLog, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改日志管理
	 * @param sysLog
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int updateByExampleSelectiveData(SysLog sysLog, Example example);

	/**
	 * @Title:
	 * @Description: 根据logId删除日志管理
	 * @param sysLog
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int deleteData(SysLog sysLog);

	/**
	 * @Title:
	 * @Description: 根据logId集合批量删除日志管理
	 * @param logIds
	 * @param sysLog
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	int deleteDataList(List logIds, SysLog sysLog);

	/**
	 * @Title:
	 * @Description: 查询全部日志管理
	 * @return List<SysLog>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	List<SysLog> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个日志管理
	 * @param example
	 * @return SysLog
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	SysLog selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询日志管理
	 * @param example
	 * @return List<SysLog>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	List<SysLog> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过logId查询日志管理
	 * @param logId
	 * @return SysLog
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	SysLog selectByPrimaryKey(Object logId);

	/**
	 * @Title:
	 * @Description: 分页查询日志管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysLog>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	PageInfoExtend<SysLog> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询日志管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysLog>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-22 15:02:44
	 */
	PageInfoExtend<SysLog> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}

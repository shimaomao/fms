package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskService
 * @Description: 收车任务业务层
 */
public interface RetrieveCarsTaskService {
	/**
	 * @Title:
	 * @Description: 分页查询收车任务
	 * @param retrieveCarsTaskVo
	 * @return PageInfoExtend<RetrieveCarsTask>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	PageInfoExtend<RetrieveCarsTaskVo> findRetrieveCarsTaskVosByPage(RetrieveCarsTaskVo retrieveCarsTaskVo);

	/**
	 * @Title:
	 * @Description:  根据retrieveCarId获取收车任务
	 * @param retrieveCarId
	 * @return RetrieveCarsTask
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-12 15:55:56
	 */
	RetrieveCarsTask findRetrieveCarsTaskByRetrieveCarId(String retrieveCarId);

	/**
	 * @Title:
	 * @Description:  根据收车任务号，获取收车任务
	 * @param retrieveCarTaskNo 收车任务号
	 * @return RetrieveCarsTask
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 15:55:56
	 */
	RetrieveCarsTask findRetrieveCarsTaskByretRieveCarTaskNo(String retrieveCarTaskNo);

	/**
	 * @Title:
	 * @Description:   发起收车任务
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/15 10:34:41
	 */
	void retrieveCarsTaskLaunch(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:   风控主管派单
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/17 02:50:49
	 */
	void retrieveCarsTaskRisk(RetrieveCarsTaskVo retrieveCarsTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 收车任务审批
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/15 11:32:25
	 */
	void retrieveCarsTaskApprove(RetrieveCarsTaskVo retrieveCarsTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description:   通过收车任务id查询收车任务
	 * @param retrieveCarId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/15 02:36:21
	 */
	RetrieveCarsTaskVo findRetrieveCarsTaskVoById(String retrieveCarId);

	/**
	 * @Title:
	 * @Description:   根据收车任务号获取收车任务
	 * @param retrieveCarTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/18 01:50:17
	 */
	RetrieveCarsTaskVo findRetrieveCarsTaskVoByTaskNo(String retrieveCarTaskNo);

	/**
	 * @Title:
	 * @Description:   收车任务登记与委派
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/19 10:34:41
	 */
	void retrieveCarsTaskRegister(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  收车任务车辆入库
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/19 10:34:41
	 */
	void retrieveCarsTaskStorage(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  收车任务确认交接
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/19 10:34:41
	 */
	void retrieveCarsTaskHandover(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  收车任务财务审核
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/19 10:34:41
	 */
	void retrieveCarsTaskFinancial(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);


	/**
	 * @Title:
	 * @Description:  收车任务总经理审核
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/20 10:34:41
	 */
	void retrieveCarsTaskAudit(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  收车任务拒绝
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/21 10:34:41
	 */
	void retrieveCarsTaskRefuse(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  收车任务退回
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/21 10:34:41
	 */
	void retrieveCarsTaskSendBack(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  收车任务退回(总经理退回)
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/21 10:34:41
	 */
	void retrieveCarsTaskAuditSendBack(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  收车任务退回(财务审核退回)
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/21 10:34:41
	 */
	void retrieveCarsTaskFinanceSendBack(RetrieveCarsTaskVo retrieveCarsTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  检查是否有正在进行的任务
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/09/25 10:34:41
	 */
	RetrieveCarsTask checkRetrieveCarsTask(RetrieveCarsTaskVo retrieveCarsTaskVo);

	/**
	 * 委托书下载
	 * @param retrieveCarsTaskVo
	 * @return
	 */
	FileVo downLoadLetter(String retrieveCarsTaskVo);

	/**
	 * @Title:
	 * @Description:  收车任务打印付款表
	 * @param retrieveCarsTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018/10/13 10:34:41
	 */
	String printPaymentOrder(RetrieveCarsTaskVo retrieveCarsTaskVo);

}

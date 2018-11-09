package cn.com.leadu.fms.activiti.service;

import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeave;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleave.ActUserLeaveVo;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveSaveVo;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveModifyVo;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveDeleteVo;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.ActUserLeaveDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveService
 * @Description: 用户请假业务层
 * @date 2018-03-14
 */
public interface ActUserLeaveService {

	/**
	 * @Title:
	 * @Description: 分页查询用户请假
	 * @param actUserLeaveVo
	 * @param sysUser
	 * @return PageInfoExtend<ActUserLeave>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:52
	 */
	PageInfoExtend<ActUserLeave> findActUserLeavesByPage(ActUserLeaveVo actUserLeaveVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 保存用户请假
	 * @param actUserLeaveSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:52
	 */
    void saveActUserLeave(ActUserLeaveSaveVo actUserLeaveSaveVo, SysUser sysUser);


	/**
	 * @Title:
	 * @Description: 修改用户请假
	 * @param actUserLeaveModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:52
	 */
	void modifyActUserLeave(ActUserLeaveModifyVo actUserLeaveModifyVo);

	/**
	 * @Title:
	 * @Description:  通过leaveId删除用户请假
	 * @param actUserLeaveDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:52
	 */
	void deleteActUserLeave(ActUserLeaveDeleteVo actUserLeaveDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过leaveId集合删除用户请假
	 * @param actUserLeaveDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:52
	 */
	void deleteActUserLeavesByLeaveIds(ActUserLeaveDeleteListVo actUserLeaveDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据leaveId获取用户请假
	 * @param leaveId
	 * @return ActUserLeave
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-14 14:35:52
	 */
	ActUserLeaveVo findActUserLeaveByLeaveId(String leaveId);


	/**
	 * @Title:
	 * @Description:   审批通过
	 * @param taskId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/19 10:32:17
	 */
	void adopt(String taskId);

}

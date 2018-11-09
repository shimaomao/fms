package cn.com.leadu.fms.activiti.service;

import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeaveApproval;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleaveapproval.ActUserLeaveApprovalVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalSaveVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalModifyVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalDeleteVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveApprovalService
 * @Description: 用户请假审批业务层
 * @date 2018-03-20
 */
public interface ActUserLeaveApprovalService {

	/**
	 * @Title:
	 * @Description: 分页查询用户请假审批
	 * @param actUserLeaveApprovalVo
	 * @return PageInfoExtend<ActUserLeaveApproval>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	PageInfoExtend<ActUserLeaveApproval> findActUserLeaveApprovalsByPage(ActUserLeaveApprovalVo actUserLeaveApprovalVo);

	/**
	 * @Title:
	 * @Description: 保存用户请假审批
	 * @param actUserLeaveApprovalSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
    void saveActUserLeaveApproval(ActUserLeaveApprovalSaveVo actUserLeaveApprovalSaveVo);


	/**
	 * @Title:
	 * @Description: 修改用户请假审批
	 * @param actUserLeaveApprovalModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	void modifyActUserLeaveApproval(ActUserLeaveApprovalModifyVo actUserLeaveApprovalModifyVo);

	/**
	 * @Title:
	 * @Description:  通过approvalId删除用户请假审批
	 * @param actUserLeaveApprovalDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	void deleteActUserLeaveApproval(ActUserLeaveApprovalDeleteVo actUserLeaveApprovalDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过approvalId集合删除用户请假审批
	 * @param actUserLeaveApprovalDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	void deleteActUserLeaveApprovalsByApprovalIds(ActUserLeaveApprovalDeleteListVo actUserLeaveApprovalDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据approvalId获取用户请假审批
	 * @param approvalId
	 * @return ActUserLeaveApproval
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-20 14:42:24
	 */
	ActUserLeaveApproval findActUserLeaveApprovalByApprovalId(String approvalId);

}

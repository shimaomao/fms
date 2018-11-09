package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.validator.defertask.vo.DeferTaskSaveVo;
import cn.com.leadu.fms.postbiz.validator.defertask.vo.DeferTaskModifyVo;
import cn.com.leadu.fms.postbiz.validator.defertask.vo.DeferTaskDeleteVo;
import cn.com.leadu.fms.postbiz.validator.defertask.vo.DeferTaskDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskService
 * @Description: 合同展期业务层
 */
public interface DeferTaskService {

	/**
	 * @Title:
	 * @Description:  根据contNo获取展期合同的当前合同信息
	 * @param deferTaskVo
	 * @return DeferTaskVo
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-1 14:35:16
	 */
	DeferTaskVo findDeferTaskVoByContNo(DeferTaskVo deferTaskVo);

	/**
	 * @Title:
	 * @Description: 提交合同展期申请
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-1 14:35:16
	 */
	void submitDeferTaskApply(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 合同展期申请审批
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-3 14:35:16
	 */
	void submitDeferTaskApprove(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 展期合同生成
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-3 14:35:16
	 */
	void generateDeferContract(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 展期合同打印
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-3 14:35:16
	 */
	void printDeferContract(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 展期合同审核
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-3 14:35:16
	 */
	void approveDeferContract(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 展期财务审核
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-3 14:35:16
	 */
	void submitFinanceApprove(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 展期总经理审核
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-3 14:35:16
	 */
	void submitManagerApprove(DeferTaskVo deferTaskVo,SysUser sysUser);
	/**
	 * @Title:
	 * @Description: 合同展期申请审批退回上一级
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-3 14:35:16
	 */
	void sendBack(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 打印付款单
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 14:35:16
	 */
	String printPaymentOrder(DeferTaskVo deferTaskVo);

	/**
	 * @Title:
	 * @Description:  根据contNo获取展期合同的展期前合同信息
	 * @param deferTaskVo
	 * @return DeferTaskVo
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-1 14:35:16
	 */
	DeferTaskVo findOldDeferTaskVoByContNo(DeferTaskVo deferTaskVo);

	/**
	 *  根据合同号查找是否有任务存在
	 * @param deferTaskVo
	 * @return
	 */
	DeferTask findDeferTaskByTaskNo(DeferTaskVo deferTaskVo);

	/**
	 * @Title:
	 * @Description: 合同展期申请审批拒绝
	 * @param deferTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-9 14:35:16
	 */
	void goRefuse(DeferTaskVo deferTaskVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 合同展期申请审批取消
	 * @param deferTaskNo 展期任务号
	 * @param memo 备注
	 * @param sysUser 当前节点用户
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-11 14:35:16
	 */
	void applyCancel(String deferTaskNo,String memo,SysUser sysUser);
}

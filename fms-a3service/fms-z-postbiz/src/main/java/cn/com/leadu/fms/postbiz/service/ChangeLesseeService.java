package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskSaveVo;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskModifyVo;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskDeleteVo;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeService
 * @Description: 承租人变更业务层
 */
public interface ChangeLesseeService {

	/**
	 * @Title:
	 * @Description:  根据contNo获取承租人变更
	 * @param contNo
	 * @return ChangeLesseeTask
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-10 15:14:54
	 */
	ChangeLesseeTask findChangeLesseeTaskByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 承租人变更风控复审
	 * @param applyRiskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-13 15:14:54
	 */
	void submitRiskApprove(ApplyRiskVo applyRiskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 承租人变更合同生成
	 * @param changeLesseeTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-13 15:14:54
	 */
	void changeContGenerate(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 承租人变更合同打印
	 * @param changeLesseeTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-13 15:14:54
	 */
	void changeContPrint(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 承租人变更合同审核
	 * @param changeLesseeTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-13 15:14:54
	 */
	void changeContApprove(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 承租人变更退回上一级
	 * @param changeLesseeTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-9-13 15:14:54
	 */
	void sendBack(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 承租人变更拒绝
	 * @param changeLesseeTaskVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-9 15:14:54
	 */
	void goRefuse(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 承租人变更取消
	 * @param deferTaskNo 展期任务号
	 * @param memo 备注
	 * @param sysUser 当前节点用户
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-11 15:14:54
	 */
	void applyCacel(String deferTaskNo,String memo,SysUser sysUser);

}

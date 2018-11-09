package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.vo.depositrisk.DepositRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author liujinge
 * @ClassName: ApplyRiskService
 * @Description:
 * @date 2018-06-04
 */
public interface DepositRiskService {
	/**
	 * @Title:
	 * @Description: 风控初审画面初始数据
	 * @param depositTaskNo 增加保证金任务号
	 * @return ApplyRiskVo
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
	DepositRiskVo findApplyRiskInit(String depositTaskNo);

	/** 
	* @Description: 保存风控数据
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/6 15:34
	*/ 
	void saveApplyRiskInit(DepositRiskVo depositRiskVo, SysUser sysUser);

	/**
	 * @param vo      入参实体类
	 * @param sysUser 当前登录用户
	 * @return DepositChangeApplyVo
	 * @Title:
	 * @Description: 初审、复审退回操作
	 * @author huzongcheng
	 * @date
	 */
	void sendBack(DepositRiskVo vo, SysUser sysUser);

	/**
	 * @param vo      入参实体类
	 * @param sysUser 当前登录用户
	 * @return DepositChangeApplyVo
	 * @Title:
	 * @Description: 初审、复审拒绝操作
	 * @author huzongcheng
	 * @date
	 */
	void refuse(DepositRiskVo vo, SysUser sysUser);
}

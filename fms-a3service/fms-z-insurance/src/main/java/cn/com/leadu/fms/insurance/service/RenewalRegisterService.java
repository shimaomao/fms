package cn.com.leadu.fms.insurance.service;

import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterSaveVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterModifyVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterDeleteVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterService
 * @Description: 续保任务一览业务层
 * @date 2018-05-17
 */
public interface RenewalRegisterService {

	/**
	 * @Title:
	 * @Description: 分页查询续保任务一览
	 * @param renewalRegisterVo
	 * @return PageInfoExtend<RenewalRegister>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-17 15:28:42
	 */
	PageInfoExtend<RenewalRegisterVo> findRenewalRegistersByPage(RenewalRegisterVo renewalRegisterVo);

	/**
	 * @Title:
	 * @Description: 根据taskNo获取一条续保任务明细
	 * @param renewalRegisterVo
	 * @return RenewalRegisterVo
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 15:28:42
	 */
	RenewalRegisterVo findRenewalRegistersByTaskNo(RenewalRegisterVo renewalRegisterVo);
	/**
	 * @Title:
	 * @Description: 续保财务确认收款
	 * @param renewalRegisterVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-17 15:28:42
	 */
    void renewalRegisterReceipt(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 续保请款
	 * @param renewalRegisterVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-10 15:28:42
	 */
	void renewalRegisterWithdraw(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 资管复核
	 * @param renewalRegisterVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-10 15:28:42
	 */
	void renewalRegisterReview(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 财务制单
	 * @param renewalRegisterVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-10 15:28:42
	 */
	void renewalRegisterVoucher(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 财务付款
	 * @param renewalRegisterVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-10 15:28:42
	 */
	void renewalRegisterPayment(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 退回上一级
	 * @param renewalRegisterVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-10 15:28:42
	 */
	void renewalRegisterSendBack(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 修改续保任务一览
	 * @param renewalRegisterModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-17 15:28:42
	 */
	void modifyRenewalRegister(RenewalRegisterModifyVo renewalRegisterModifyVo);

	/**
	 * @Title:
	 * @Description:  通过renewalRegisterId删除续保任务一览
	 * @param renewalRegisterDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-17 15:28:42
	 */
	void deleteRenewalRegister(RenewalRegisterDeleteVo renewalRegisterDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过renewalRegisterId集合删除续保任务一览
	 * @param renewalRegisterDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-17 15:28:42
	 */
	void deleteRenewalRegistersByRenewalRegisterIds(RenewalRegisterDeleteListVo renewalRegisterDeleteListVo);


	/**
	 * @Title:
	 * @Description:  根据renewalRegisterId获取续保任务一览
	 * @param renewalRegisterId
	 * @return RenewalRegister
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-17 15:28:42
	 */
	RenewalRegister findRenewalRegisterByRenewalRegisterId(String renewalRegisterId);

	/**
	 * @Title:
	 * @Description: 更新续保任务登记表并启动流程
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date
	 */
	void saveContInsuranceFromRenewalRegister(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 再次资管确认提交
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date
	 */
	void reSaveContInsuranceFromRenewalRegister(RenewalRegisterVo renewalRegisterVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 续保付款单打印
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	String printRenewalRegister(RenewalRegisterVo renewalRegisterVo);


}

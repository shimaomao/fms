package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentDeleteListVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentDeleteVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentModifyVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentSaveVo;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentService
 * @Description: 提前还款业务层
 * @date 2018-05-10
 */
public interface ContPrepaymentService {

	/**
	 * @Title:
	 * @Description: 分页查询提前还款
	 * @param contPrepaymentVo
	 * @return PageInfoExtend<ContPrepayment>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	PageInfoExtend<ContPrepayment> findContPrepaymentsByPage(ContPrepaymentVo contPrepaymentVo);

	/** 
	* @Description: 分页查询提前还款vo
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/10 19:57
	*/ 
	PageInfoExtend<ContPrepaymentVo> findContPrepaymentListByPage(ContPrepaymentVo contPrepaymentVo);

	/**
	 * @Title:
	 * @Description: 保存提前还款
	 * @param contPrepaymentSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
    void saveContPrepayment(ContPrepaymentSaveVo contPrepaymentSaveVo);


	/**
	 * @Title:
	 * @Description: 修改提前还款
	 * @param contPrepaymentModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	void modifyContPrepayment(ContPrepaymentModifyVo contPrepaymentModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contPrepaymentId删除提前还款
	 * @param contPrepaymentDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	void deleteContPrepayment(ContPrepaymentDeleteVo contPrepaymentDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contPrepaymentId集合删除提前还款
	 * @param contPrepaymentDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	void deleteContPrepaymentsByContPrepaymentIds(ContPrepaymentDeleteListVo contPrepaymentDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contPrepaymentId获取提前还款
	 * @param contPrepaymentId
	 * @return ContPrepayment
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-10 17:47:06
	 */
	ContPrepayment findContPrepaymentByContPrepaymentId(String contPrepaymentId);

	/** 
	* @Description: 根据合同编号获取提前还款信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/11 15:17
	*/ 
	ContPrepayment findContPrepaymentByContNo(String contNo);

	/**
	 * @Description: 根据业务号获取提前还款信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/6/20 17:22
	 */
	ContPrepayment findContPrepaymentByContPrepaymentNo(String contPrepaymentNo);

	/** 
	* @Description: 根据合同编号查询提前还款vo
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/23 11:31
	*/ 
	ContPrepaymentVo findContPrepaymentVoByContNo(String contNo);

	/**
	 * @Description: 根据业务号查询提前还款vo
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/7/23 11:31
	 */
	ContPrepaymentVo findContPrepaymentVoByContPrepaymentNo(String contPrepaymentNo);

	/** 
	* @Description: 根据合同编号构造提前还款和提前还款明细信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/11 15:58
	*/ 
	ContPrepaymentVo findContPrepaymentWithDetailByContNo(String contNo);

	/**
	 * @Description: 根据业务号查询提前还款和提前还款明细信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/11 15:58
	 */
	ContPrepaymentVo findContPrepaymentWithDetailByContPrepaymentNo(String contPrepaymentNo);

	/** 
	* @Description: 保存提前还款和明细
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 19:01
	*/ 
	void saveContPrepaymentWithDetail(ContPrepaymentVo contPrepaymentVo);

	/**
	* @Description: 财务确认
	* @param:
	* @return:
	* @Author: lijunjun
	* @Date: 2018/5/14 19:01
	*/
	void financeConfirm(ContReceiptVo contReceiptVo);

	/** 
	* @Description: 打印提前还款
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/28 17:44
	*/ 
	String printPrepayment(ContPrepaymentVo contPrepaymentVo);

	/** 
	* @Description:  打印提前还款结清证明
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/29 18:17
	*/ 
	String printPrepaymentJQZM(String contPrepaymentNo);

	/**
	 * @param contPrepaymentApproveVo
	 * @Description: 打印付款单
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/8/27 18:17
	 */
	 String printPaymentOrder(ContPrepaymentApproveVo contPrepaymentApproveVo);

	/**
	 * @Description: 车辆出库(赎回)
	 * @param: vehicleDisposalVo 车辆出库信息
	 * @return:
	 * @Author: wangxue
	 * @Date: 2018/5/14 18:57
	 */
	void prePayVehicleShipment(VehicleDisposalVo vehicleDisposalVo);

	/**
	 * @Description: 根据合同号，获取车辆处置信息(待处置)
	 * @param: contNo 合同号
	 * @return:
	 * @Author: wangxue
	 * @Date: 2018/5/14 18:57
	 */
	VehicleDisposal findVehicleDisposalByContNo(String contNo);

	/**
	 * @Description: 根据合同编号，获取车辆的过户任务信息
	 * @param: contNo 合同编号
	 * @return:
	 * @Author: wangxue
	 * @Date: 2018/5/14 18:57
	 */
	TransferInfo findTransferInfoByContNo(String contNo);
}

package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContPayService
 * @Description: 财务付款表业务层
 * @date 2018-04-11
 */
public interface ContPayService {

	/**
	 * @Title:
	 * @Description: 分页查询财务付款表
	 * @param contPayVo
	 * @return PageInfoExtend<ContPay>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:17
	 */
	PageInfoExtend<ContPay> findContPaysByPage(ContPayVo contPayVo);

	/**
	 * @Title:
	 * @Description:  根据contPayId获取财务付款表
	 * @param contPayId
	 * @return ContPay
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:17
	 */
	ContPay findContPayByContPayId(String contPayId);

	/**
	 * @Title:
	 * @Description:  根据contPayId获取财务付款表
	 * @param contPayList
	 * @return ContPay
	 * @throws
	 * @author liujinge
	 * @date 2018-4-11 10:10:17
	 */
	int insertContPayList(List<ContPay> contPayList);

	/**
	 * @Title:
	 * @Description: 通过付款类型和业务关联号(合同编号)查询财务付款表
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */

	ContPay findContPayByBizCodeAndPaymentType(String paymentType,String bizCode);

	/**
	 * @Title:
	 * @Description: 通过付款类型和业务关联号(合同编号)更新财务付款表
	 * @return
	 * @throws
	 * @author liujinge
	 * @date
	 */

	int updateContPayByBizCodeAndPaymentType(ContPay contPay);

	/** 
	* @Description: 查询财务付款表（业务类型，业务关联号，付款款项）
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/25 17:29
	*/
	ContPay findContPayListByBizCodeAndPayFundAndPaymentType(String paymentType,String bizCode,String payFund);
}

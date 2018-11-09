package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;

/**
 * @author liujinge
 * @ClassName: ContInspectService
 * @Description: 合同文件核查
 * @date 2018-03-23
 */
public interface ContPaymentDetailService {

	/**
	 * @Title:
	 * @Description: 通过合同编号和订单编号获取ContPaymentVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */

	public ContPaymentVo findContPaymentVo(String contNo, String applyNo);


}

package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contpayment.ContPaymentVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContInspectService
 * @Description: 合同文件核查
 * @date 2018-03-23
 */
public interface ContPaymentService {

	/**
	 * @Title:
	 * @Description: 合同生成前确认
	 * @param contPaymentVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
    void submit(ContPaymentVo contPaymentVo);

	void sendBack(ContPaymentVo contPaymentVo);

}
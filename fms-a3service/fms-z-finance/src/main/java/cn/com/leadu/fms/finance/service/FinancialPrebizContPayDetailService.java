package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;

/**
 * @author yebangqiang
 * @ClassName: FinancialPrebizContPayService
 * @Description: 贷前财务付款清单明细查询
 * @date 2018-07-19
 */
public interface FinancialPrebizContPayDetailService {

	/**
	 * @Title:
	 * @Description: 贷前财务付款清单明细查询
	 * @param contPayVo
	 * @return java.lang.String
	 * @throws
	 * @author yebangqiang
	 * @date
	 */
	PageInfoExtend<ContPay> findFinancialPrebizContPayDetailServiceByPage(ContPayVo contPayVo);

	/**
	 * @Title:
	 * @Description: 贷前财务付款清单汇总查询
	 * @param contPayVo
	 * @return java.lang.String
	 * @throws
	 * @author yebangqiang
	 * @date
	 */
	PageInfoExtend<ContPayVo> findContPayInfoByPage(ContPayVo contPayVo);
}
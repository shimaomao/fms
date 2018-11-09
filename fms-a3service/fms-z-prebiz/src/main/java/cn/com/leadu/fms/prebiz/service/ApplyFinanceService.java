package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;

/**
 * @author wangxue
 * @ClassName: ApplyFinanceService
 * @Description: 融资信息业务层
 * @date 2018-03-24
 */
public interface ApplyFinanceService {

	/**
	 * @Title:
	 * @Description: 分页查询融资信息
	 * @param applyFinanceVo
	 * @return PageInfoExtend<ApplyFinance>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	PageInfoExtend<ApplyFinance> findApplyFinancesByPage(ApplyFinanceVo applyFinanceVo);

	/**
	 * @Title:
	 * @Description:  根据applyFinId获取融资信息
	 * @param applyFinId
	 * @return ApplyFinance
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:12:16
	 */
	ApplyFinance findApplyFinanceByApplyFinId(String applyFinId);

	/**
	 * @Title:
	 * @Description:  根据applyFinId获取融资信息
	 * @param applyNo
	 * @return ApplyFinance
	 * @throws
	 * @author wangxue
	 * @date 2018-3-16
	 */
	ApplyFinance findApplyFinanceByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  保存融资方案信息
	 * @param applyFinance
	 * @throws
	 * @author wangxue
	 * @date 2018-3-16
	 */
	void saveApplyFinance(ApplyFinance applyFinance);

	/**
	 * @Title:
	 * @Description:  更新融资方案信息
	 * @param applyFinance
	 * @throws
	 * @author wangxue
	 * @date 2018-4-15
	 */
	void modifyApplyFinance(ApplyFinance applyFinance);

	/**
	 * @Title:
	 * @Description:  根据订单编号，获取融资信息
	 * @param applyNo 订单编号
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29
	 */
	ApplyFinanceVo findApplyFinanceVoByApplyNo(String applyNo);


}

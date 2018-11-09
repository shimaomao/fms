package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata.FinancialVoucherDataVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataService
 * @Description: 财务凭证数据业务层
 * @date 2018-06-21
 */
public interface FinancialVoucherDataService {

	/**
	 * @Title:
	 * @Description: 分页查询财务凭证数据
	 * @param finVouDataVo
	 * @return PageInfoExtend<FinancialVoucherData>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:10
	 */
	PageInfoExtend<FinancialVoucherData> findFinVouDataVosByPage(FinancialVoucherDataVo finVouDataVo);

	/**
	 * @Title:
	 * @Description: 根据凭证号查询对应的凭证数据
	 * @param:  voucherNo 凭证号
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/16 0016 19:37
	 */
	List<FinancialVoucherDataVo> findFinVouDataVoDetails(String voucherNo);

	/**
	 * @Title:
	 * @Description:   根据财务凭证id获取财务凭证核算数据
	 * @param voucherDataId 财务凭证id
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/11 03:01:10
	 */
	List<FinancialVoucherAssisVo> findFinVouAssisVosByVouDataId(String voucherDataId);

	/**
	 * @Title:
	 * @Description:   根据凭证号集合获取凭证数据
	 * @param voucherNos
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/23 05:25:14
	 */
	List<FinancialVoucherData> findFinancialVoucherDatas(List<String> voucherNos);

}

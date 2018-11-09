package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractFinanceService
 * @Description: 合同融资信息业务层
 * @date 2018-03-23
 */
public interface ContractFinanceService {

	/**
	 * @Title:
	 * @Description: 分页查询合同融资信息
	 * @param contractFinanceVo
	 * @return PageInfoExtend<ContractFinance>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:11
	 */
	PageInfoExtend<ContractFinance> findContractFinancesByPage(ContractFinanceVo contractFinanceVo);

	/**
	 * @Title:
	 * @Description:  根据contFinId获取合同融资信息
	 * @param contFinId
	 * @return ContractFinance
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:11
	 */
	ContractFinance findContractFinanceByContFinId(String contFinId);

	/**
	 * @Title:
	 * @Description:  批量插入合同融资信息
	 * @param contractFinanceList
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:11
	 */
	int insertContractFinances(List<ContractFinance> contractFinanceList);

	/**
	 * @Title:
	 * @Description:  通过合同号查询
	 * @param contNo
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-30 18:46:11
	 */
	ContractFinanceVo findContractFinanceVoByContNo(String contNo);

	/** 
	* @Description: 根据合同号查找保证金，保证金返还方式 = 一次性的场合 ，不是一次性返回0
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 16:42
	*/ 
	BigDecimal findContractFinancesDepositByContNo(String contNo);

	/**
	 * @param contractFinance
	 * @Description: 根据合同号更新合同融资信息
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/14 16:35
	 */
    void updateContractFinanceByContNo(ContractFinance contractFinance);

	/**
	 * @Title:
	 * @Description:  有模板出excel测试
	 * @param httpServletResponse
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/01/31 03:06:04
	 */
	void testExport(HttpServletResponse httpServletResponse);
}

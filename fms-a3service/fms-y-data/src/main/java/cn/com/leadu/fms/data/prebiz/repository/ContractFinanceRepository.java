package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractFinanceRepository
 * @Description: 合同融资信息Repository层
 * @date 2018-03-23
 */
public interface ContractFinanceRepository {

	/**
	 * @Title:
	 * @Description: 新增合同融资信息
	 * @param contractFinance
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int insertData(ContractFinance contractFinance);

	/**
	 * @Title:
	 * @Description: 批量保存合同融资信息
	 * @param contractFinances
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int insertDataList(List<ContractFinance> contractFinances);

	/**
	 * @Title:
	 * @Description: 修改合同融资信息
	 * @param contractFinance
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int updateByPrimaryKeyData(ContractFinance contractFinance);

	/**
	 * @Title:
	 * @Description: 批量修改合同融资信息
	 * @param contractFinances
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int updateByPrimaryKeyDataList(List<ContractFinance> contractFinances);

	/**
	 * @Title:
	 * @Description: 动态修改合同融资信息
	 * @param contractFinance
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int updateByPrimaryKeySelectiveData(ContractFinance contractFinance);

	/**
	 * @Title:
	 * @Description: 批量动态修改合同融资信息
	 * @param contractFinances
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContractFinance> contractFinances);

	/**
	 * @Title:
	 * @Description: 根据条件修改合同融资信息
	 * @param contractFinance
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int updateByExampleData(ContractFinance contractFinance, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改合同融资信息
	 * @param contractFinance
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int updateByExampleSelectiveData(ContractFinance contractFinance, Example example);

	/**
	 * @Title:
	 * @Description: 根据contFinId删除合同融资信息
	 * @param contractFinance
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int deleteData(ContractFinance contractFinance);

	/**
	 * @Title:
	 * @Description: 根据contFinId集合批量删除合同融资信息
	 * @param contFinIds
	 * @param contractFinance
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	int deleteDataList(List contFinIds, ContractFinance contractFinance);

	/**
	 * @Title:
	 * @Description: 查询全部合同融资信息
	 * @return List<ContractFinance>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	List<ContractFinance> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个合同融资信息
	 * @param example
	 * @return ContractFinance
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	ContractFinance selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询合同融资信息
	 * @param example
	 * @return List<ContractFinance>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	List<ContractFinance> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contFinId查询合同融资信息
	 * @param contFinId
	 * @return ContractFinance
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	ContractFinance selectByPrimaryKey(Object contFinId);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContractFinance>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	PageInfoExtend<ContractFinance> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资信息vo
	 * @param contNo
	 * @return PageInfoExtend<ContractFinance>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:46:10
	 */
	ContractFinanceVo selectContractFinanceVoByContNo(String contNo);

	/** 
	* @Description: 通过合同编号查询合同请款时合同融资相关信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/9 15:01
	*/ 
	ContRequestPayVo selectContractRequestFinanceByContNo(String contNo);

	/**
	* @Description:  通过合同编号查询合同确认收款时合同融资相关信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/13 11:34
	*/ 
	ContReceiptPayVo selectContReceiptPayFinanceByContNo(String contNo);

}

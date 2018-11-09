package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountListVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContRepayAccountRepository
 * @Description: 融资合同还款信息Repository层
 * @date 2018-03-23
 */
public interface ContRepayAccountRepository {

	/**
	 * @Title:
	 * @Description: 新增融资合同还款信息
	 * @param contRepayAccount
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int insertData(ContRepayAccount contRepayAccount);

	/**
	 * @Title:
	 * @Description: 批量保存融资合同还款信息
	 * @param contRepayAccounts
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int insertDataList(List<ContRepayAccount> contRepayAccounts);

	/**
	 * @Title:
	 * @Description: 修改融资合同还款信息
	 * @param contRepayAccount
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int updateByPrimaryKeyData(ContRepayAccount contRepayAccount);

	/**
	 * @Title:
	 * @Description: 批量修改融资合同还款信息
	 * @param contRepayAccounts
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int updateByPrimaryKeyDataList(List<ContRepayAccount> contRepayAccounts);

	/**
	 * @Title:
	 * @Description: 动态修改融资合同还款信息
	 * @param contRepayAccount
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int updateByPrimaryKeySelectiveData(ContRepayAccount contRepayAccount);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资合同还款信息
	 * @param contRepayAccounts
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContRepayAccount> contRepayAccounts);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资合同还款信息
	 * @param contRepayAccount
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int updateByExampleData(ContRepayAccount contRepayAccount, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资合同还款信息
	 * @param contRepayAccount
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int updateByExampleSelectiveData(ContRepayAccount contRepayAccount, Example example);

	/**
	 * @Title:
	 * @Description: 根据repayAccId删除融资合同还款信息
	 * @param contRepayAccount
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int deleteData(ContRepayAccount contRepayAccount);

	/**
	 * @Title:
	 * @Description: 根据repayAccId集合批量删除融资合同还款信息
	 * @param repayAccIds
	 * @param contRepayAccount
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	int deleteDataList(List repayAccIds, ContRepayAccount contRepayAccount);

	/**
	 * @Title:
	 * @Description: 查询全部融资合同还款信息
	 * @return List<ContRepayAccount>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	List<ContRepayAccount> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资合同还款信息
	 * @param example
	 * @return ContRepayAccount
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	ContRepayAccount selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资合同还款信息
	 * @param example
	 * @return List<ContRepayAccount>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	List<ContRepayAccount> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过repayAccId查询融资合同还款信息
	 * @param repayAccId
	 * @return ContRepayAccount
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	ContRepayAccount selectByPrimaryKey(Object repayAccId);

	/**
	 * @Title:
	 * @Description: 分页查询融资合同还款信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContRepayAccount>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	PageInfoExtend<ContRepayAccount> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资合同还款信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ContRepayAccountListVo>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	PageInfoExtend<ContRepayAccountListVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}

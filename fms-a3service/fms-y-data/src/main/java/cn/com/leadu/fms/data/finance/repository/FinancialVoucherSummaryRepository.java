package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryRepository
 * @Description: 财务凭证管理Repository层
 * @date 2018-07-21
 */
public interface FinancialVoucherSummaryRepository {

	/**
	 * @Title:
	 * @Description: 新增财务凭证管理
	 * @param financialVoucherSummary
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int insertData(FinancialVoucherSummary financialVoucherSummary);

	/**
	 * @Title:
	 * @Description: 批量保存财务凭证管理
	 * @param financialVoucherSummarys
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int insertDataList(List<FinancialVoucherSummary> financialVoucherSummarys);

	/**
	 * @Title:
	 * @Description: 修改财务凭证管理
	 * @param financialVoucherSummary
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByPrimaryKeyData(FinancialVoucherSummary financialVoucherSummary);

	/**
	 * @Title:
	 * @Description: 批量修改财务凭证管理
	 * @param financialVoucherSummarys
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherSummary> financialVoucherSummarys);

	/**
	 * @Title:
	 * @Description: 动态修改财务凭证管理
	 * @param financialVoucherSummary
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherSummary financialVoucherSummary);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务凭证管理
	 * @param financialVoucherSummarys
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSummary> financialVoucherSummarys);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务凭证管理
	 * @param financialVoucherSummary
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByExampleData(FinancialVoucherSummary financialVoucherSummary, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务凭证管理
	 * @param financialVoucherSummary
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByExampleSelectiveData(FinancialVoucherSummary financialVoucherSummary, Example example);

	/**
	 * @Title:
	 * @Description: 根据voucherSummaryId删除财务凭证管理
	 * @param financialVoucherSummary
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int deleteData(FinancialVoucherSummary financialVoucherSummary);

	/**
	 * @Title:
	 * @Description: 根据voucherSummaryId集合批量删除财务凭证管理
	 * @param voucherSummaryIds
	 * @param financialVoucherSummary
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int deleteDataList(List voucherSummaryIds, FinancialVoucherSummary financialVoucherSummary);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务凭证管理
	 * @param example
	 * @param financialVoucherSummary
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int deleteExampleData(Example example, FinancialVoucherSummary financialVoucherSummary);

	/**
	 * @Title:
	 * @Description: 查询全部财务凭证管理
	 * @return List<FinancialVoucherSummary>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	List<FinancialVoucherSummary> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务凭证管理
	 * @param example
	 * @return FinancialVoucherSummary
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	FinancialVoucherSummary selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务凭证管理
	 * @param example
	 * @return List<FinancialVoucherSummary>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	List<FinancialVoucherSummary> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过voucherSummaryId查询财务凭证管理
	 * @param voucherSummaryId
	 * @return FinancialVoucherSummary
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	FinancialVoucherSummary selectByPrimaryKey(Object voucherSummaryId);

	/**
	 * @Title:
	 * @Description: 分页查询财务凭证管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinancialVoucherSummary>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	PageInfoExtend<FinancialVoucherSummary> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务凭证管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改财务凭证管理
	 * @param financialVoucherSummary,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByPrimaryKeyData(FinancialVoucherSummary financialVoucherSummary, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改财务凭证管理,并进行排他
	 * @param financialVoucherSummarys
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherSummary> financialVoucherSummarys, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改财务凭证管理,并进行排他
	 * @param financialVoucherSummary
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherSummary financialVoucherSummary, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务凭证管理,并进行排他
	 * @param financialVoucherSummarys
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSummary> financialVoucherSummarys, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务凭证管理,并进行排他
	 * @param financialVoucherSummary
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByExampleData(FinancialVoucherSummary financialVoucherSummary, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务凭证管理,并进行排他
	 * @param financialVoucherSummary
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:44:52
	 */
	int updateByExampleSelectiveData(FinancialVoucherSummary financialVoucherSummary, Example example, boolean exclusive);

}

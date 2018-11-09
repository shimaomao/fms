package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailRepository
 * @Description: 凭证类型明细管理Repository层
 * @date 2018-06-20
 */
public interface FinancialVoucherDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增凭证类型明细管理
	 * @param financialVoucherDetail
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int insertData(FinancialVoucherDetail financialVoucherDetail);

	/**
	 * @Title:
	 * @Description: 批量保存凭证类型明细管理
	 * @param financialVoucherDetails
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int insertDataList(List<FinancialVoucherDetail> financialVoucherDetails);

	/**
	 * @Title:
	 * @Description: 修改凭证类型明细管理
	 * @param financialVoucherDetail
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByPrimaryKeyData(FinancialVoucherDetail financialVoucherDetail);

	/**
	 * @Title:
	 * @Description: 批量修改凭证类型明细管理
	 * @param financialVoucherDetails
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherDetail> financialVoucherDetails);

	/**
	 * @Title:
	 * @Description: 动态修改凭证类型明细管理
	 * @param financialVoucherDetail
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherDetail financialVoucherDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改凭证类型明细管理
	 * @param financialVoucherDetails
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherDetail> financialVoucherDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改凭证类型明细管理
	 * @param financialVoucherDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByExampleData(FinancialVoucherDetail financialVoucherDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改凭证类型明细管理
	 * @param financialVoucherDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByExampleSelectiveData(FinancialVoucherDetail financialVoucherDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据voucherDetailId删除凭证类型明细管理
	 * @param financialVoucherDetail
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int deleteData(FinancialVoucherDetail financialVoucherDetail);

	/**
	 * @Title:
	 * @Description: 根据voucherDetailId集合批量删除凭证类型明细管理
	 * @param voucherDetailIds
	 * @param financialVoucherDetail
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int deleteDataList(List voucherDetailIds, FinancialVoucherDetail financialVoucherDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除凭证类型明细管理
	 * @param example
	 * @param financialVoucherDetail
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int deleteExampleData(Example example, FinancialVoucherDetail financialVoucherDetail);

	/**
	 * @Title:
	 * @Description: 查询全部凭证类型明细管理
	 * @return List<FinancialVoucherDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	List<FinancialVoucherDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个凭证类型明细管理
	 * @param example
	 * @return FinancialVoucherDetail
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	FinancialVoucherDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询凭证类型明细管理
	 * @param example
	 * @return List<FinancialVoucherDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	List<FinancialVoucherDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过voucherDetailId查询凭证类型明细管理
	 * @param voucherDetailId
	 * @return FinancialVoucherDetail
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	FinancialVoucherDetail selectByPrimaryKey(Object voucherDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询凭证类型明细管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinancialVoucherDetail>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	PageInfoExtend<FinancialVoucherDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询凭证类型明细管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改凭证类型明细管理
	 * @param financialVoucherDetail,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByPrimaryKeyData(FinancialVoucherDetail financialVoucherDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改凭证类型明细管理,并进行排他
	 * @param financialVoucherDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherDetail> financialVoucherDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改凭证类型明细管理,并进行排他
	 * @param financialVoucherDetail
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherDetail financialVoucherDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改凭证类型明细管理,并进行排他
	 * @param financialVoucherDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherDetail> financialVoucherDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改凭证类型明细管理,并进行排他
	 * @param financialVoucherDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByExampleData(FinancialVoucherDetail financialVoucherDetail, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改凭证类型明细管理,并进行排他
	 * @param financialVoucherDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:39:31
	 */
	int updateByExampleSelectiveData(FinancialVoucherDetail financialVoucherDetail, Example example, boolean exclusive);

}

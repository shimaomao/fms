package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherRepository
 * @Description: 凭证类型管理Repository层
 * @date 2018-06-20
 */
public interface FinancialVoucherRepository {

	/**
	 * @Title:
	 * @Description: 新增凭证类型管理
	 * @param financialVoucher
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int insertData(FinancialVoucher financialVoucher);

	/**
	 * @Title:
	 * @Description: 批量保存凭证类型管理
	 * @param financialVouchers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int insertDataList(List<FinancialVoucher> financialVouchers);

	/**
	 * @Title:
	 * @Description: 修改凭证类型管理
	 * @param financialVoucher
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByPrimaryKeyData(FinancialVoucher financialVoucher);

	/**
	 * @Title:
	 * @Description: 批量修改凭证类型管理
	 * @param financialVouchers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucher> financialVouchers);

	/**
	 * @Title:
	 * @Description: 动态修改凭证类型管理
	 * @param financialVoucher
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucher financialVoucher);

	/**
	 * @Title:
	 * @Description: 批量动态修改凭证类型管理
	 * @param financialVouchers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucher> financialVouchers);

	/**
	 * @Title:
	 * @Description: 根据条件修改凭证类型管理
	 * @param financialVoucher
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByExampleData(FinancialVoucher financialVoucher, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改凭证类型管理
	 * @param financialVoucher
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByExampleSelectiveData(FinancialVoucher financialVoucher, Example example);

	/**
	 * @Title:
	 * @Description: 根据voucherId删除凭证类型管理
	 * @param financialVoucher
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int deleteData(FinancialVoucher financialVoucher);

	/**
	 * @Title:
	 * @Description: 根据voucherId集合批量删除凭证类型管理
	 * @param voucherIds
	 * @param financialVoucher
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int deleteDataList(List voucherIds, FinancialVoucher financialVoucher);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除凭证类型管理
	 * @param example
	 * @param financialVoucher
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int deleteExampleData(Example example, FinancialVoucher financialVoucher);

	/**
	 * @Title:
	 * @Description: 查询全部凭证类型管理
	 * @return List<FinancialVoucher>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	List<FinancialVoucher> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个凭证类型管理
	 * @param example
	 * @return FinancialVoucher
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	FinancialVoucher selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询凭证类型管理
	 * @param example
	 * @return List<FinancialVoucher>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	List<FinancialVoucher> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过voucherId查询凭证类型管理
	 * @param voucherId
	 * @return FinancialVoucher
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	FinancialVoucher selectByPrimaryKey(Object voucherId);

	/**
	 * @Title:
	 * @Description: 分页查询凭证类型管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinancialVoucher>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	PageInfoExtend<FinancialVoucher> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询凭证类型管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改凭证类型管理
	 * @param financialVoucher,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByPrimaryKeyData(FinancialVoucher financialVoucher, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改凭证类型管理,并进行排他
	 * @param financialVouchers
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucher> financialVouchers, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改凭证类型管理,并进行排他
	 * @param financialVoucher
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucher financialVoucher, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改凭证类型管理,并进行排他
	 * @param financialVouchers
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucher> financialVouchers, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改凭证类型管理,并进行排他
	 * @param financialVoucher
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByExampleData(FinancialVoucher financialVoucher, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改凭证类型管理,并进行排他
	 * @param financialVoucher
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-20 10:21:55
	 */
	int updateByExampleSelectiveData(FinancialVoucher financialVoucher, Example example, boolean exclusive);

}

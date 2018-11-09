package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSend;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendRepository
 * @Description: 财务发送管理Repository层
 * @date 2018-07-21
 */
public interface FinancialVoucherSendRepository {

	/**
	 * @Title:
	 * @Description: 新增财务发送管理
	 * @param financialVoucherSend
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int insertData(FinancialVoucherSend financialVoucherSend);

	/**
	 * @Title:
	 * @Description: 批量保存财务发送管理
	 * @param financialVoucherSends
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int insertDataList(List<FinancialVoucherSend> financialVoucherSends);

	/**
	 * @Title:
	 * @Description: 修改财务发送管理
	 * @param financialVoucherSend
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByPrimaryKeyData(FinancialVoucherSend financialVoucherSend);

	/**
	 * @Title:
	 * @Description: 批量修改财务发送管理
	 * @param financialVoucherSends
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherSend> financialVoucherSends);

	/**
	 * @Title:
	 * @Description: 动态修改财务发送管理
	 * @param financialVoucherSend
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherSend financialVoucherSend);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务发送管理
	 * @param financialVoucherSends
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSend> financialVoucherSends);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务发送管理
	 * @param financialVoucherSend
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByExampleData(FinancialVoucherSend financialVoucherSend, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务发送管理
	 * @param financialVoucherSend
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByExampleSelectiveData(FinancialVoucherSend financialVoucherSend, Example example);

	/**
	 * @Title:
	 * @Description: 根据voucherSendId删除财务发送管理
	 * @param financialVoucherSend
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int deleteData(FinancialVoucherSend financialVoucherSend);

	/**
	 * @Title:
	 * @Description: 根据voucherSendId集合批量删除财务发送管理
	 * @param voucherSendIds
	 * @param financialVoucherSend
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int deleteDataList(List voucherSendIds, FinancialVoucherSend financialVoucherSend);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务发送管理
	 * @param example
	 * @param financialVoucherSend
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int deleteExampleData(Example example, FinancialVoucherSend financialVoucherSend);

	/**
	 * @Title:
	 * @Description: 查询全部财务发送管理
	 * @return List<FinancialVoucherSend>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	List<FinancialVoucherSend> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务发送管理
	 * @param example
	 * @return FinancialVoucherSend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	FinancialVoucherSend selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务发送管理
	 * @param example
	 * @return List<FinancialVoucherSend>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	List<FinancialVoucherSend> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过voucherSendId查询财务发送管理
	 * @param voucherSendId
	 * @return FinancialVoucherSend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	FinancialVoucherSend selectByPrimaryKey(Object voucherSendId);

	/**
	 * @Title:
	 * @Description: 分页查询财务发送管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinancialVoucherSend>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	PageInfoExtend<FinancialVoucherSend> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务发送管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改财务发送管理
	 * @param financialVoucherSend,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByPrimaryKeyData(FinancialVoucherSend financialVoucherSend, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改财务发送管理,并进行排他
	 * @param financialVoucherSends
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherSend> financialVoucherSends, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改财务发送管理,并进行排他
	 * @param financialVoucherSend
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherSend financialVoucherSend, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务发送管理,并进行排他
	 * @param financialVoucherSends
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSend> financialVoucherSends, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务发送管理,并进行排他
	 * @param financialVoucherSend
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByExampleData(FinancialVoucherSend financialVoucherSend, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务发送管理,并进行排他
	 * @param financialVoucherSend
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-7-21 13:45:18
	 */
	int updateByExampleSelectiveData(FinancialVoucherSend financialVoucherSend, Example example, boolean exclusive);

}

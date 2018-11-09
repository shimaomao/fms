package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherAssisRepository
 * @Description: 财务凭证核算数据Repository层
 * @date 2018-06-26
 */
public interface FinancialVoucherAssisRepository {

	/**
	 * @Title:
	 * @Description: 新增财务凭证核算数据
	 * @param financialVoucherAssis
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int insertData(FinancialVoucherAssis financialVoucherAssis);

	/**
	 * @Title:
	 * @Description: 批量保存财务凭证核算数据
	 * @param financialVoucherAssiss
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int insertDataList(List<FinancialVoucherAssis> financialVoucherAssiss);

	/**
	 * @Title:
	 * @Description: 修改财务凭证核算数据
	 * @param financialVoucherAssis
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByPrimaryKeyData(FinancialVoucherAssis financialVoucherAssis);

	/**
	 * @Title:
	 * @Description: 批量修改财务凭证核算数据
	 * @param financialVoucherAssiss
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherAssis> financialVoucherAssiss);

	/**
	 * @Title:
	 * @Description: 动态修改财务凭证核算数据
	 * @param financialVoucherAssis
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherAssis financialVoucherAssis);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务凭证核算数据
	 * @param financialVoucherAssiss
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherAssis> financialVoucherAssiss);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务凭证核算数据
	 * @param financialVoucherAssis
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByExampleData(FinancialVoucherAssis financialVoucherAssis, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务凭证核算数据
	 * @param financialVoucherAssis
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByExampleSelectiveData(FinancialVoucherAssis financialVoucherAssis, Example example);

	/**
	 * @Title:
	 * @Description: 根据voucherAssisId删除财务凭证核算数据
	 * @param financialVoucherAssis
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int deleteData(FinancialVoucherAssis financialVoucherAssis);

	/**
	 * @Title:
	 * @Description: 根据voucherAssisId集合批量删除财务凭证核算数据
	 * @param voucherAssisIds
	 * @param financialVoucherAssis
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int deleteDataList(List voucherAssisIds, FinancialVoucherAssis financialVoucherAssis);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务凭证核算数据
	 * @param example
	 * @param financialVoucherAssis
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int deleteExampleData(Example example, FinancialVoucherAssis financialVoucherAssis);

	/**
	 * @Title:
	 * @Description: 查询全部财务凭证核算数据
	 * @return List<FinancialVoucherAssis>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	List<FinancialVoucherAssis> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务凭证核算数据
	 * @param example
	 * @return FinancialVoucherAssis
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	FinancialVoucherAssis selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务凭证核算数据
	 * @param example
	 * @return List<FinancialVoucherAssis>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	List<FinancialVoucherAssis> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过voucherAssisId查询财务凭证核算数据
	 * @param voucherAssisId
	 * @return FinancialVoucherAssis
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	FinancialVoucherAssis selectByPrimaryKey(Object voucherAssisId);

	/**
	 * @Title:
	 * @Description: 分页查询财务凭证核算数据
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinancialVoucherAssis>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	PageInfoExtend<FinancialVoucherAssis> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务凭证核算数据vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改财务凭证核算数据
	 * @param financialVoucherAssis,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByPrimaryKeyData(FinancialVoucherAssis financialVoucherAssis, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改财务凭证核算数据,并进行排他
	 * @param financialVoucherAssiss
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherAssis> financialVoucherAssiss, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改财务凭证核算数据,并进行排他
	 * @param financialVoucherAssis
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherAssis financialVoucherAssis, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务凭证核算数据,并进行排他
	 * @param financialVoucherAssiss
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherAssis> financialVoucherAssiss, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务凭证核算数据,并进行排他
	 * @param financialVoucherAssis
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByExampleData(FinancialVoucherAssis financialVoucherAssis, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务凭证核算数据,并进行排他
	 * @param financialVoucherAssis
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-26 10:12:36
	 */
	int updateByExampleSelectiveData(FinancialVoucherAssis financialVoucherAssis, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description:   根据财务凭证id获取核算数据
	 * @param voucherDataId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/11 03:13:03
	 */
	List<FinancialVoucherAssisVo> selectFinancialVoucherAssisVosByVouDataId(String voucherDataId);

	/**
	 * @Title:
	 * @Description:   根据财务凭证id获取金蝶用户列表
	 * @param finVouAssisVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/30 10:35:44
	 */
	List<KingDeeCusVo> selectKingDeeCusVosByVouDataIds(FinancialVoucherAssisVo finVouAssisVo);

}

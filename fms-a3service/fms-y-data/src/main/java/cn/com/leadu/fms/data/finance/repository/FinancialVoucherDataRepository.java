package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata.FinancialVoucherDataVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataRepository
 * @Description: 财务凭证数据Repository层
 * @date 2018-06-21
 */
public interface FinancialVoucherDataRepository {

	/**
	 * @Title:
	 * @Description: 新增财务凭证数据
	 * @param financialVoucherData
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int insertData(FinancialVoucherData financialVoucherData);

	/**
	 * @Title:
	 * @Description: 批量保存财务凭证数据
	 * @param financialVoucherDatas
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int insertDataList(List<FinancialVoucherData> financialVoucherDatas);

	/**
	 * @Title:
	 * @Description: 修改财务凭证数据
	 * @param financialVoucherData
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByPrimaryKeyData(FinancialVoucherData financialVoucherData);

	/**
	 * @Title:
	 * @Description: 批量修改财务凭证数据
	 * @param financialVoucherDatas
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherData> financialVoucherDatas);

	/**
	 * @Title:
	 * @Description: 动态修改财务凭证数据
	 * @param financialVoucherData
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherData financialVoucherData);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务凭证数据
	 * @param financialVoucherDatas
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherData> financialVoucherDatas);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务凭证数据
	 * @param financialVoucherData
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByExampleData(FinancialVoucherData financialVoucherData, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务凭证数据
	 * @param financialVoucherData
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByExampleSelectiveData(FinancialVoucherData financialVoucherData, Example example);

	/**
	 * @Title:
	 * @Description: 根据voucherDataId删除财务凭证数据
	 * @param financialVoucherData
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int deleteData(FinancialVoucherData financialVoucherData);

	/**
	 * @Title:
	 * @Description: 根据voucherDataId集合批量删除财务凭证数据
	 * @param voucherDataIds
	 * @param financialVoucherData
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int deleteDataList(List voucherDataIds, FinancialVoucherData financialVoucherData);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务凭证数据
	 * @param example
	 * @param financialVoucherData
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int deleteExampleData(Example example, FinancialVoucherData financialVoucherData);

	/**
	 * @Title:
	 * @Description: 查询全部财务凭证数据
	 * @return List<FinancialVoucherData>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	List<FinancialVoucherData> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务凭证数据
	 * @param example
	 * @return FinancialVoucherData
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	FinancialVoucherData selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务凭证数据
	 * @param example
	 * @return List<FinancialVoucherData>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	List<FinancialVoucherData> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过voucherDataId查询财务凭证数据
	 * @param voucherDataId
	 * @return FinancialVoucherData
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	FinancialVoucherData selectByPrimaryKey(Object voucherDataId);

	/**
	 * @Title:
	 * @Description: 分页查询财务凭证数据
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinancialVoucherData>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	PageInfoExtend<FinancialVoucherData> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务凭证数据vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改财务凭证数据
	 * @param financialVoucherData,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByPrimaryKeyData(FinancialVoucherData financialVoucherData, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改财务凭证数据,并进行排他
	 * @param financialVoucherDatas
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByPrimaryKeyDataList(List<FinancialVoucherData> financialVoucherDatas, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改财务凭证数据,并进行排他
	 * @param financialVoucherData
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(FinancialVoucherData financialVoucherData, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务凭证数据,并进行排他
	 * @param financialVoucherDatas
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherData> financialVoucherDatas, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务凭证数据,并进行排他
	 * @param financialVoucherData
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByExampleData(FinancialVoucherData financialVoucherData, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务凭证数据,并进行排他
	 * @param financialVoucherData
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-6-21 15:34:09
	 */
	int updateByExampleSelectiveData(FinancialVoucherData financialVoucherData, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description:   查询财务凭证数据详情list
	 * @param finVouDataVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/11 12:00:22
	 */
	List<FinancialVoucherDataVo> selectFinancialVoucherDataVos(FinancialVoucherDataVo finVouDataVo);

	/**
	 * @Title:
	 * @Description: 根据凭证号查询对应的凭证数据
	 * @param:  voucherNo 凭证号
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/16 0016 19:37
	 */
	List<FinancialVoucherDataVo> selectFinVouDataVoDetails(String voucherNo);

}

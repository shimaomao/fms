package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ContCostRepository
 * @Description: 客户费用Repository层
 */
public interface ContCostRepository {

	/**
	 * @Title:
	 * @Description: 新增客户费用
	 * @param contCost
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int insertData(ContCost contCost);

	/**
	 * @Title:
	 * @Description: 批量保存客户费用
	 * @param contCosts
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int insertDataList(List<ContCost> contCosts);

	/**
	 * @Title:
	 * @Description: 修改客户费用
	 * @param contCost
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByPrimaryKeyData(ContCost contCost);

	/**
	 * @Title:
	 * @Description: 批量修改客户费用
	 * @param contCosts
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByPrimaryKeyDataList(List<ContCost> contCosts);

	/**
	 * @Title:
	 * @Description: 动态修改客户费用
	 * @param contCost
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByPrimaryKeySelectiveData(ContCost contCost);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户费用
	 * @param contCosts
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContCost> contCosts);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户费用
	 * @param contCost
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByExampleData(ContCost contCost, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户费用
	 * @param contCost
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByExampleSelectiveData(ContCost contCost, Example example);

	/**
	 * @Title:
	 * @Description: 根据contCostId删除客户费用
	 * @param contCost
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int deleteData(ContCost contCost);

	/**
	 * @Title:
	 * @Description: 根据contCostId集合批量删除客户费用
	 * @param contCostIds
	 * @param contCost
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int deleteDataList(List contCostIds, ContCost contCost);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除客户费用
	 * @param example
	 * @param contCost
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int deleteExampleData(Example example, ContCost contCost);

	/**
	 * @Title:
	 * @Description: 查询全部客户费用
	 * @return List<ContCost>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	List<ContCost> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户费用
	 * @param example
	 * @return ContCost
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	ContCost selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户费用
	 * @param example
	 * @return List<ContCost>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	List<ContCost> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contCostId查询客户费用
	 * @param contCostId
	 * @return ContCost
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	ContCost selectByPrimaryKey(Object contCostId);

	/**
	 * @Title:
	 * @Description: 分页查询客户费用
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContCost>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	PageInfoExtend<ContCost> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询客户费用vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改客户费用
	 * @param contCost,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByPrimaryKeyData(ContCost contCost, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改客户费用,并进行排他
	 * @param contCosts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByPrimaryKeyDataList(List<ContCost> contCosts, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改客户费用,并进行排他
	 * @param contCost
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ContCost contCost, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户费用,并进行排他
	 * @param contCosts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContCost> contCosts, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户费用,并进行排他
	 * @param contCost
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByExampleData(ContCost contCost, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户费用,并进行排他
	 * @param contCost
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:31:46
	 */
	int updateByExampleSelectiveData(ContCost contCost, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description:  根据合同号,获取对应款项的金额合计
	 * @param contNo 合同编号
	 * @param costItem 款项
	 * @throws
	 * @author wangxue
	 * @date 2018-9-18 16:12:19
	 */
	BigDecimal selectSumCostAmountByContNo(String contNo, String costItem);

}

package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtGuaranteeRepository
 * @Description: 风控担保人信息Repository层
 * @date 2018-06-04
 */
public interface RiskMgmtGuaranteeRepository {

	/**
	 * @Title:
	 * @Description: 新增风控担保人信息
	 * @param riskMgmtGuarantee
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int insertData(RiskMgmtGuarantee riskMgmtGuarantee);

	/**
	 * @Title:
	 * @Description: 批量保存风控担保人信息
	 * @param riskMgmtGuarantees
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int insertDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees);

	/**
	 * @Title:
	 * @Description: 修改风控担保人信息
	 * @param riskMgmtGuarantee
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByPrimaryKeyData(RiskMgmtGuarantee riskMgmtGuarantee);

	/**
	 * @Title:
	 * @Description: 批量修改风控担保人信息
	 * @param riskMgmtGuarantees
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByPrimaryKeyDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees);

	/**
	 * @Title:
	 * @Description: 动态修改风控担保人信息
	 * @param riskMgmtGuarantee
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByPrimaryKeySelectiveData(RiskMgmtGuarantee riskMgmtGuarantee);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控担保人信息
	 * @param riskMgmtGuarantees
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控担保人信息
	 * @param riskMgmtGuarantee
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByExampleData(RiskMgmtGuarantee riskMgmtGuarantee, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控担保人信息
	 * @param riskMgmtGuarantee
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByExampleSelectiveData(RiskMgmtGuarantee riskMgmtGuarantee, Example example);

	/**
	 * @Title:
	 * @Description: 根据riskMgmtGuaranteeId删除风控担保人信息
	 * @param riskMgmtGuarantee
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int deleteData(RiskMgmtGuarantee riskMgmtGuarantee);

	/**
	 * @Title:
	 * @Description: 根据riskMgmtGuaranteeId集合批量删除风控担保人信息
	 * @param riskMgmtGuaranteeIds
	 * @param riskMgmtGuarantee
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int deleteDataList(List riskMgmtGuaranteeIds,RiskMgmtGuarantee riskMgmtGuarantee);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除风控担保人信息
	 * @param example
	 * @param riskMgmtGuarantee
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int deleteExampleData(Example example,RiskMgmtGuarantee riskMgmtGuarantee);

	/**
	 * @Title:
	 * @Description: 查询全部风控担保人信息
	 * @return List<RiskMgmtGuarantee>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	List<RiskMgmtGuarantee> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个风控担保人信息
	 * @param example
	 * @return RiskMgmtGuarantee
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	RiskMgmtGuarantee selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询风控担保人信息
	 * @param example
	 * @return List<RiskMgmtGuarantee>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	List<RiskMgmtGuarantee> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过riskMgmtGuaranteeId查询风控担保人信息
	 * @param riskMgmtGuaranteeId
	 * @return RiskMgmtGuarantee
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	RiskMgmtGuarantee selectByPrimaryKey(Object riskMgmtGuaranteeId);

	/**
	 * @Title:
	 * @Description: 分页查询风控担保人信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RiskMgmtGuarantee>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	PageInfoExtend<RiskMgmtGuarantee> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询风控担保人信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改风控担保人信息
	 * @param riskMgmtGuarantee,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByPrimaryKeyData(RiskMgmtGuarantee riskMgmtGuarantee,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改风控担保人信息,并进行排他
	 * @param riskMgmtGuarantees
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByPrimaryKeyDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改风控担保人信息,并进行排他
	 * @param riskMgmtGuarantee
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RiskMgmtGuarantee riskMgmtGuarantee,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控担保人信息,并进行排他
	 * @param riskMgmtGuarantees
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskMgmtGuarantee> riskMgmtGuarantees,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控担保人信息,并进行排他
	 * @param riskMgmtGuarantee
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByExampleData(RiskMgmtGuarantee riskMgmtGuarantee, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控担保人信息,并进行排他
	 * @param riskMgmtGuarantee
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	int updateByExampleSelectiveData(RiskMgmtGuarantee riskMgmtGuarantee, Example example,boolean exclusive);

}

package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk.RiskTelchkVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkRepository
 * @Description: 风控电核信息Repository层
 * @date 2018-06-04
 */
public interface RiskTelchkRepository {

	/**
	 * @Title:
	 * @Description: 新增风控电核信息
	 * @param riskTelchk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int insertData(RiskTelchk riskTelchk);

	/**
	 * @Title:
	 * @Description: 批量保存风控电核信息
	 * @param riskTelchks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int insertDataList(List<RiskTelchk> riskTelchks);

	/**
	 * @Title:
	 * @Description: 修改风控电核信息
	 * @param riskTelchk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByPrimaryKeyData(RiskTelchk riskTelchk);

	/**
	 * @Title:
	 * @Description: 批量修改风控电核信息
	 * @param riskTelchks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByPrimaryKeyDataList(List<RiskTelchk> riskTelchks);

	/**
	 * @Title:
	 * @Description: 动态修改风控电核信息
	 * @param riskTelchk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByPrimaryKeySelectiveData(RiskTelchk riskTelchk);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控电核信息
	 * @param riskTelchks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskTelchk> riskTelchks);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控电核信息
	 * @param riskTelchk
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByExampleData(RiskTelchk riskTelchk, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控电核信息
	 * @param riskTelchk
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByExampleSelectiveData(RiskTelchk riskTelchk, Example example);

	/**
	 * @Title:
	 * @Description: 根据riskTelchkId删除风控电核信息
	 * @param riskTelchk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int deleteData(RiskTelchk riskTelchk);

	/**
	 * @Title:
	 * @Description: 根据riskTelchkId集合批量删除风控电核信息
	 * @param riskTelchkIds
	 * @param riskTelchk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int deleteDataList(List riskTelchkIds,RiskTelchk riskTelchk);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除风控电核信息
	 * @param example
	 * @param riskTelchk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int deleteExampleData(Example example,RiskTelchk riskTelchk);

	/**
	 * @Title:
	 * @Description: 查询全部风控电核信息
	 * @return List<RiskTelchk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	List<RiskTelchk> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个风控电核信息
	 * @param example
	 * @return RiskTelchk
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	RiskTelchk selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询风控电核信息
	 * @param example
	 * @return List<RiskTelchk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	List<RiskTelchk> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过riskTelchkId查询风控电核信息
	 * @param riskTelchkId
	 * @return RiskTelchk
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	RiskTelchk selectByPrimaryKey(Object riskTelchkId);

	/**
	 * @Title:
	 * @Description: 分页查询风控电核信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RiskTelchk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	PageInfoExtend<RiskTelchk> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询风控电核信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改风控电核信息
	 * @param riskTelchk,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByPrimaryKeyData(RiskTelchk riskTelchk,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改风控电核信息,并进行排他
	 * @param riskTelchks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByPrimaryKeyDataList(List<RiskTelchk> riskTelchks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改风控电核信息,并进行排他
	 * @param riskTelchk
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RiskTelchk riskTelchk,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控电核信息,并进行排他
	 * @param riskTelchks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskTelchk> riskTelchks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控电核信息,并进行排他
	 * @param riskTelchk
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByExampleData(RiskTelchk riskTelchk, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控电核信息,并进行排他
	 * @param riskTelchk
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:44
	 */
	int updateByExampleSelectiveData(RiskTelchk riskTelchk, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据订单编号 获取电核信息
	 * @param applyNo 订单编号
	 * @return List<RiskTelchkVo>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 17:39:58
	 */
	List<RiskTelchkVo> selectRiskTelchkByApplyNo(String applyNo);
}

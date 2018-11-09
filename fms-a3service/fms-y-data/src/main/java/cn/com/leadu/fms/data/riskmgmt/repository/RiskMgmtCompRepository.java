package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtCompRepository
 * @Description: 风控企业信息Repository层
 * @date 2018-06-04
 */
public interface RiskMgmtCompRepository {

	/**
	 * @Title:
	 * @Description: 新增风控企业信息
	 * @param riskMgmtComp
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int insertData(RiskMgmtComp riskMgmtComp);

	/**
	 * @Title:
	 * @Description: 批量保存风控企业信息
	 * @param riskMgmtComps
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int insertDataList(List<RiskMgmtComp> riskMgmtComps);

	/**
	 * @Title:
	 * @Description: 修改风控企业信息
	 * @param riskMgmtComp
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByPrimaryKeyData(RiskMgmtComp riskMgmtComp);

	/**
	 * @Title:
	 * @Description: 批量修改风控企业信息
	 * @param riskMgmtComps
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByPrimaryKeyDataList(List<RiskMgmtComp> riskMgmtComps);

	/**
	 * @Title:
	 * @Description: 动态修改风控企业信息
	 * @param riskMgmtComp
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByPrimaryKeySelectiveData(RiskMgmtComp riskMgmtComp);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控企业信息
	 * @param riskMgmtComps
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskMgmtComp> riskMgmtComps);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控企业信息
	 * @param riskMgmtComp
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByExampleData(RiskMgmtComp riskMgmtComp, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控企业信息
	 * @param riskMgmtComp
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByExampleSelectiveData(RiskMgmtComp riskMgmtComp, Example example);

	/**
	 * @Title:
	 * @Description: 根据riskMgmtCompId删除风控企业信息
	 * @param riskMgmtComp
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int deleteData(RiskMgmtComp riskMgmtComp);

	/**
	 * @Title:
	 * @Description: 根据riskMgmtCompId集合批量删除风控企业信息
	 * @param riskMgmtCompIds
	 * @param riskMgmtComp
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int deleteDataList(List riskMgmtCompIds,RiskMgmtComp riskMgmtComp);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除风控企业信息
	 * @param example
	 * @param riskMgmtComp
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int deleteExampleData(Example example,RiskMgmtComp riskMgmtComp);

	/**
	 * @Title:
	 * @Description: 查询全部风控企业信息
	 * @return List<RiskMgmtComp>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	List<RiskMgmtComp> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个风控企业信息
	 * @param example
	 * @return RiskMgmtComp
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	RiskMgmtComp selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询风控企业信息
	 * @param example
	 * @return List<RiskMgmtComp>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	List<RiskMgmtComp> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过riskMgmtCompId查询风控企业信息
	 * @param riskMgmtCompId
	 * @return RiskMgmtComp
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	RiskMgmtComp selectByPrimaryKey(Object riskMgmtCompId);

	/**
	 * @Title:
	 * @Description: 分页查询风控企业信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RiskMgmtComp>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	PageInfoExtend<RiskMgmtComp> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询风控企业信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改风控企业信息
	 * @param riskMgmtComp,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByPrimaryKeyData(RiskMgmtComp riskMgmtComp,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改风控企业信息,并进行排他
	 * @param riskMgmtComps
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByPrimaryKeyDataList(List<RiskMgmtComp> riskMgmtComps,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改风控企业信息,并进行排他
	 * @param riskMgmtComp
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RiskMgmtComp riskMgmtComp,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控企业信息,并进行排他
	 * @param riskMgmtComps
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskMgmtComp> riskMgmtComps,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控企业信息,并进行排他
	 * @param riskMgmtComp
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByExampleData(RiskMgmtComp riskMgmtComp, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控企业信息,并进行排他
	 * @param riskMgmtComp
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	int updateByExampleSelectiveData(RiskMgmtComp riskMgmtComp, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 通过certifyNo查询风控个人信息
	 * @param certifNo
	 * @return RiskMgmtComp
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
    RiskMgmtComp selectRiskMgmtCompByMain(String certifNo,String applyNo);
}

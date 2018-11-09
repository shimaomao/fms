package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtPersonRepository
 * @Description: 风控个人信息Repository层
 * @date 2018-06-04
 */
public interface RiskMgmtPersonRepository {

	/**
	 * @Title:
	 * @Description: 新增风控个人信息
	 * @param riskMgmtPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int insertData(RiskMgmtPerson riskMgmtPerson);

	/**
	 * @Title:
	 * @Description: 批量保存风控个人信息
	 * @param riskMgmtPersons
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int insertDataList(List<RiskMgmtPerson> riskMgmtPersons);

	/**
	 * @Title:
	 * @Description: 修改风控个人信息
	 * @param riskMgmtPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByPrimaryKeyData(RiskMgmtPerson riskMgmtPerson);

	/**
	 * @Title:
	 * @Description: 批量修改风控个人信息
	 * @param riskMgmtPersons
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByPrimaryKeyDataList(List<RiskMgmtPerson> riskMgmtPersons);

	/**
	 * @Title:
	 * @Description: 动态修改风控个人信息
	 * @param riskMgmtPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByPrimaryKeySelectiveData(RiskMgmtPerson riskMgmtPerson);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控个人信息
	 * @param riskMgmtPersons
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskMgmtPerson> riskMgmtPersons);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控个人信息
	 * @param riskMgmtPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByExampleData(RiskMgmtPerson riskMgmtPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控个人信息
	 * @param riskMgmtPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByExampleSelectiveData(RiskMgmtPerson riskMgmtPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据riskMgmtPersonId删除风控个人信息
	 * @param riskMgmtPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int deleteData(RiskMgmtPerson riskMgmtPerson);

	/**
	 * @Title:
	 * @Description: 根据riskMgmtPersonId集合批量删除风控个人信息
	 * @param riskMgmtPersonIds
	 * @param riskMgmtPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int deleteDataList(List riskMgmtPersonIds,RiskMgmtPerson riskMgmtPerson);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除风控个人信息
	 * @param example
	 * @param riskMgmtPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int deleteExampleData(Example example,RiskMgmtPerson riskMgmtPerson);

	/**
	 * @Title:
	 * @Description: 查询全部风控个人信息
	 * @return List<RiskMgmtPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	List<RiskMgmtPerson> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个风控个人信息
	 * @param example
	 * @return RiskMgmtPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	RiskMgmtPerson selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询风控个人信息
	 * @param example
	 * @return List<RiskMgmtPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	List<RiskMgmtPerson> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过riskMgmtPersonId查询风控个人信息
	 * @param riskMgmtPersonId
	 * @return RiskMgmtPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	RiskMgmtPerson selectByPrimaryKey(Object riskMgmtPersonId);

	/**
	 * @Title:
	 * @Description: 分页查询风控个人信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RiskMgmtPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	PageInfoExtend<RiskMgmtPerson> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询风控个人信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改风控个人信息
	 * @param riskMgmtPerson,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByPrimaryKeyData(RiskMgmtPerson riskMgmtPerson,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改风控个人信息,并进行排他
	 * @param riskMgmtPersons
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByPrimaryKeyDataList(List<RiskMgmtPerson> riskMgmtPersons,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改风控个人信息,并进行排他
	 * @param riskMgmtPerson
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RiskMgmtPerson riskMgmtPerson,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改风控个人信息,并进行排他
	 * @param riskMgmtPersons
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskMgmtPerson> riskMgmtPersons,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改风控个人信息,并进行排他
	 * @param riskMgmtPerson
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByExampleData(RiskMgmtPerson riskMgmtPerson, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改风控个人信息,并进行排他
	 * @param riskMgmtPerson
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	int updateByExampleSelectiveData(RiskMgmtPerson riskMgmtPerson, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 通过certifyNo查询风控个人信息
	 * @param certifNo
	 * @return RiskMgmtPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
    RiskMgmtPerson selectRiskMgmtPersonByMain(String certifNo,String applyNo);
}

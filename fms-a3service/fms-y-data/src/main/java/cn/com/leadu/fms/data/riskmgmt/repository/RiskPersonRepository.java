package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskPerson;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskPersonRepository
 * @Description: 个人风险信息Repository层
 * @date 2018-06-04
 */
public interface RiskPersonRepository {

	/**
	 * @Title:
	 * @Description: 新增个人风险信息
	 * @param riskPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int insertData(RiskPerson riskPerson);

	/**
	 * @Title:
	 * @Description: 批量保存个人风险信息
	 * @param riskPersons
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int insertDataList(List<RiskPerson> riskPersons);

	/**
	 * @Title:
	 * @Description: 修改个人风险信息
	 * @param riskPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByPrimaryKeyData(RiskPerson riskPerson);

	/**
	 * @Title:
	 * @Description: 批量修改个人风险信息
	 * @param riskPersons
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByPrimaryKeyDataList(List<RiskPerson> riskPersons);

	/**
	 * @Title:
	 * @Description: 动态修改个人风险信息
	 * @param riskPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByPrimaryKeySelectiveData(RiskPerson riskPerson);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人风险信息
	 * @param riskPersons
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskPerson> riskPersons);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人风险信息
	 * @param riskPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByExampleData(RiskPerson riskPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人风险信息
	 * @param riskPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByExampleSelectiveData(RiskPerson riskPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据riskPersonId删除个人风险信息
	 * @param riskPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int deleteData(RiskPerson riskPerson);

	/**
	 * @Title:
	 * @Description: 根据riskPersonId集合批量删除个人风险信息
	 * @param riskPersonIds
	 * @param riskPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int deleteDataList(List riskPersonIds,RiskPerson riskPerson);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除个人风险信息
	 * @param example
	 * @param riskPerson
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int deleteExampleData(Example example,RiskPerson riskPerson);

	/**
	 * @Title:
	 * @Description: 查询全部个人风险信息
	 * @return List<RiskPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	List<RiskPerson> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个个人风险信息
	 * @param example
	 * @return RiskPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	RiskPerson selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询个人风险信息
	 * @param example
	 * @return List<RiskPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	List<RiskPerson> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过riskPersonId查询个人风险信息
	 * @param riskPersonId
	 * @return RiskPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	RiskPerson selectByPrimaryKey(Object riskPersonId);

	/**
	 * @Title:
	 * @Description: 分页查询个人风险信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RiskPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	PageInfoExtend<RiskPerson> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询个人风险信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改个人风险信息
	 * @param riskPerson,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByPrimaryKeyData(RiskPerson riskPerson,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改个人风险信息,并进行排他
	 * @param riskPersons
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByPrimaryKeyDataList(List<RiskPerson> riskPersons,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改个人风险信息,并进行排他
	 * @param riskPerson
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RiskPerson riskPerson,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人风险信息,并进行排他
	 * @param riskPersons
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskPerson> riskPersons,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人风险信息,并进行排他
	 * @param riskPerson
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByExampleData(RiskPerson riskPerson, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人风险信息,并进行排他
	 * @param riskPerson
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:14
	 */
	int updateByExampleSelectiveData(RiskPerson riskPerson, Example example,boolean exclusive);

}

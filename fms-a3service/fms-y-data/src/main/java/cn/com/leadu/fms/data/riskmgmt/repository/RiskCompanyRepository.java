package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskCompany;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskCompanyRepository
 * @Description: 企业风险信息Repository层
 * @date 2018-06-04
 */
public interface RiskCompanyRepository {

	/**
	 * @Title:
	 * @Description: 新增企业风险信息
	 * @param riskCompany
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int insertData(RiskCompany riskCompany);

	/**
	 * @Title:
	 * @Description: 批量保存企业风险信息
	 * @param riskCompanys
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int insertDataList(List<RiskCompany> riskCompanys);

	/**
	 * @Title:
	 * @Description: 修改企业风险信息
	 * @param riskCompany
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByPrimaryKeyData(RiskCompany riskCompany);

	/**
	 * @Title:
	 * @Description: 批量修改企业风险信息
	 * @param riskCompanys
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByPrimaryKeyDataList(List<RiskCompany> riskCompanys);

	/**
	 * @Title:
	 * @Description: 动态修改企业风险信息
	 * @param riskCompany
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByPrimaryKeySelectiveData(RiskCompany riskCompany);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业风险信息
	 * @param riskCompanys
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskCompany> riskCompanys);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业风险信息
	 * @param riskCompany
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByExampleData(RiskCompany riskCompany, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业风险信息
	 * @param riskCompany
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByExampleSelectiveData(RiskCompany riskCompany, Example example);

	/**
	 * @Title:
	 * @Description: 根据riskCompanyId删除企业风险信息
	 * @param riskCompany
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int deleteData(RiskCompany riskCompany);

	/**
	 * @Title:
	 * @Description: 根据riskCompanyId集合批量删除企业风险信息
	 * @param riskCompanyIds
	 * @param riskCompany
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int deleteDataList(List riskCompanyIds,RiskCompany riskCompany);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除企业风险信息
	 * @param example
	 * @param riskCompany
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int deleteExampleData(Example example,RiskCompany riskCompany);

	/**
	 * @Title:
	 * @Description: 查询全部企业风险信息
	 * @return List<RiskCompany>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	List<RiskCompany> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个企业风险信息
	 * @param example
	 * @return RiskCompany
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	RiskCompany selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询企业风险信息
	 * @param example
	 * @return List<RiskCompany>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	List<RiskCompany> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过riskCompanyId查询企业风险信息
	 * @param riskCompanyId
	 * @return RiskCompany
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	RiskCompany selectByPrimaryKey(Object riskCompanyId);

	/**
	 * @Title:
	 * @Description: 分页查询企业风险信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RiskCompany>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	PageInfoExtend<RiskCompany> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询企业风险信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改企业风险信息
	 * @param riskCompany,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByPrimaryKeyData(RiskCompany riskCompany,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改企业风险信息,并进行排他
	 * @param riskCompanys
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByPrimaryKeyDataList(List<RiskCompany> riskCompanys,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改企业风险信息,并进行排他
	 * @param riskCompany
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(RiskCompany riskCompany,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业风险信息,并进行排他
	 * @param riskCompanys
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByPrimaryKeySelectiveDataList(List<RiskCompany> riskCompanys,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业风险信息,并进行排他
	 * @param riskCompany
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByExampleData(RiskCompany riskCompany, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业风险信息,并进行排他
	 * @param riskCompany
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	int updateByExampleSelectiveData(RiskCompany riskCompany, Example example,boolean exclusive);

}

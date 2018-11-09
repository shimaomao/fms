package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyRepository
 * @Description: CRM企业信息Repository层
 * @date 2018-05-23
 */
public interface CrmCompanyRepository {

	/**
	 * @Title:
	 * @Description: 新增CRM企业信息
	 * @param crmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int insertData(CrmCompany crmCompany);

	/**
	 * @Title:
	 * @Description: 批量保存CRM企业信息
	 * @param crmCompanys
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int insertDataList(List<CrmCompany> crmCompanys);

	/**
	 * @Title:
	 * @Description: 修改CRM企业信息
	 * @param crmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int updateByPrimaryKeyData(CrmCompany crmCompany);

	/**
	 * @Title:
	 * @Description: 批量修改CRM企业信息
	 * @param crmCompanys
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int updateByPrimaryKeyDataList(List<CrmCompany> crmCompanys);

	/**
	 * @Title:
	 * @Description: 动态修改CRM企业信息
	 * @param crmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int updateByPrimaryKeySelectiveData(CrmCompany crmCompany);

	/**
	 * @Title:
	 * @Description: 批量动态修改CRM企业信息
	 * @param crmCompanys
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int updateByPrimaryKeySelectiveDataList(List<CrmCompany> crmCompanys);

	/**
	 * @Title:
	 * @Description: 根据条件修改CRM企业信息
	 * @param crmCompany
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int updateByExampleData(CrmCompany crmCompany, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改CRM企业信息
	 * @param crmCompany
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int updateByExampleSelectiveData(CrmCompany crmCompany, Example example);

	/**
	 * @Title:
	 * @Description: 根据companyId删除CRM企业信息
	 * @param crmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int deleteData(CrmCompany crmCompany);

	/**
	 * @Title:
	 * @Description: 根据companyId集合批量删除CRM企业信息
	 * @param companyIds
	 * @param crmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int deleteDataList(List companyIds, CrmCompany crmCompany);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除CRM企业信息
	 * @param example
	 * @param crmCompany
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	int deleteExampleData(Example example, CrmCompany crmCompany);

	/**
	 * @Title:
	 * @Description: 查询全部CRM企业信息
	 * @return List<CrmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	List<CrmCompany> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个CRM企业信息
	 * @param example
	 * @return CrmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	CrmCompany selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询CRM企业信息
	 * @param example
	 * @return List<CrmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	List<CrmCompany> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过companyId查询CRM企业信息
	 * @param companyId
	 * @return CrmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	CrmCompany selectByPrimaryKey(Object companyId);

	/**
	 * @Title:
	 * @Description: 分页查询CRM企业信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CrmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	PageInfoExtend<CrmCompany> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询CRM企业信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}

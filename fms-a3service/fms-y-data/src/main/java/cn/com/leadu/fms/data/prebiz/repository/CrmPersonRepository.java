package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonRepository
 * @Description: CRM个人信息Repository层
 * @date 2018-05-23
 */
public interface CrmPersonRepository {

	/**
	 * @Title:
	 * @Description: 新增CRM个人信息
	 * @param crmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int insertData(CrmPerson crmPerson);

	/**
	 * @Title:
	 * @Description: 批量保存CRM个人信息
	 * @param crmPersons
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int insertDataList(List<CrmPerson> crmPersons);

	/**
	 * @Title:
	 * @Description: 修改CRM个人信息
	 * @param crmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int updateByPrimaryKeyData(CrmPerson crmPerson);

	/**
	 * @Title:
	 * @Description: 批量修改CRM个人信息
	 * @param crmPersons
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int updateByPrimaryKeyDataList(List<CrmPerson> crmPersons);

	/**
	 * @Title:
	 * @Description: 动态修改CRM个人信息
	 * @param crmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int updateByPrimaryKeySelectiveData(CrmPerson crmPerson);

	/**
	 * @Title:
	 * @Description: 批量动态修改CRM个人信息
	 * @param crmPersons
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int updateByPrimaryKeySelectiveDataList(List<CrmPerson> crmPersons);

	/**
	 * @Title:
	 * @Description: 根据条件修改CRM个人信息
	 * @param crmPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int updateByExampleData(CrmPerson crmPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改CRM个人信息
	 * @param crmPerson
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int updateByExampleSelectiveData(CrmPerson crmPerson, Example example);

	/**
	 * @Title:
	 * @Description: 根据personId删除CRM个人信息
	 * @param crmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int deleteData(CrmPerson crmPerson);

	/**
	 * @Title:
	 * @Description: 根据personId集合批量删除CRM个人信息
	 * @param personIds
	 * @param crmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int deleteDataList(List personIds, CrmPerson crmPerson);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除CRM个人信息
	 * @param example
	 * @param crmPerson
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	int deleteExampleData(Example example, CrmPerson crmPerson);

	/**
	 * @Title:
	 * @Description: 查询全部CRM个人信息
	 * @return List<CrmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	List<CrmPerson> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个CRM个人信息
	 * @param example
	 * @return CrmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	CrmPerson selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询CRM个人信息
	 * @param example
	 * @return List<CrmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	List<CrmPerson> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过personId查询CRM个人信息
	 * @param personId
	 * @return CrmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	CrmPerson selectByPrimaryKey(Object personId);

	/**
	 * @Title:
	 * @Description: 分页查询CRM个人信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CrmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	PageInfoExtend<CrmPerson> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询CRM个人信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:07
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}

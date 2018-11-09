package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmContactRepository
 * @Description: 客户联系人信息Repository层
 * @date 2018-03-27
 */
public interface CstmContactRepository {

	/**
	 * @Title:
	 * @Description: 新增客户联系人信息
	 * @param cstmContact
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int insertData(CstmContact cstmContact);

	/**
	 * @Title:
	 * @Description: 批量保存客户联系人信息
	 * @param cstmContacts
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int insertDataList(List<CstmContact> cstmContacts);

	/**
	 * @Title:
	 * @Description: 修改客户联系人信息
	 * @param cstmContact
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int updateByPrimaryKeyData(CstmContact cstmContact);

	/**
	 * @Title:
	 * @Description: 批量修改客户联系人信息
	 * @param cstmContacts
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int updateByPrimaryKeyDataList(List<CstmContact> cstmContacts);

	/**
	 * @Title:
	 * @Description: 动态修改客户联系人信息
	 * @param cstmContact
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int updateByPrimaryKeySelectiveData(CstmContact cstmContact);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户联系人信息
	 * @param cstmContacts
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int updateByPrimaryKeySelectiveDataList(List<CstmContact> cstmContacts);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户联系人信息
	 * @param cstmContact
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int updateByExampleData(CstmContact cstmContact, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户联系人信息
	 * @param cstmContact
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int updateByExampleSelectiveData(CstmContact cstmContact, Example example);

	/**
	 * @Title:
	 * @Description: 根据contactId删除客户联系人信息
	 * @param cstmContact
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int deleteData(CstmContact cstmContact);

	/**
	 * @Title:
	 * @Description: 根据contactId集合批量删除客户联系人信息
	 * @param contactIds
	 * @param cstmContact
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int deleteDataList(List contactIds, CstmContact cstmContact);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除客户联系人信息
	 * @param example
	 * @param cstmContact
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	int deleteExampleData(Example example, CstmContact cstmContact);

	/**
	 * @Title:
	 * @Description: 查询全部客户联系人信息
	 * @return List<CstmContact>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	List<CstmContact> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户联系人信息
	 * @param example
	 * @return CstmContact
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	CstmContact selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户联系人信息
	 * @param example
	 * @return List<CstmContact>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	List<CstmContact> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contactId查询客户联系人信息
	 * @param contactId
	 * @return CstmContact
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	CstmContact selectByPrimaryKey(Object contactId);

	/**
	 * @Title:
	 * @Description: 分页查询客户联系人信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CstmContact>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	PageInfoExtend<CstmContact> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询客户联系人信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<CstmContact>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:43
	 */
	PageInfoExtend<CstmContact> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}

package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.ContactsChange;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeRepository
 * @Description: 联系人信息变更Repository层
 * @date 2018-09-01
 */
public interface ContactsChangeRepository {

	/**
	 * @Title:
	 * @Description: 新增联系人信息变更
	 * @param contactsChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int insertData(ContactsChange contactsChange);

	/**
	 * @Title:
	 * @Description: 批量保存联系人信息变更
	 * @param contactsChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int insertDataList(List<ContactsChange> contactsChanges);

	/**
	 * @Title:
	 * @Description: 修改联系人信息变更
	 * @param contactsChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByPrimaryKeyData(ContactsChange contactsChange);

	/**
	 * @Title:
	 * @Description: 批量修改联系人信息变更
	 * @param contactsChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByPrimaryKeyDataList(List<ContactsChange> contactsChanges);

	/**
	 * @Title:
	 * @Description: 动态修改联系人信息变更
	 * @param contactsChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByPrimaryKeySelectiveData(ContactsChange contactsChange);

	/**
	 * @Title:
	 * @Description: 批量动态修改联系人信息变更
	 * @param contactsChanges
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContactsChange> contactsChanges);

	/**
	 * @Title:
	 * @Description: 根据条件修改联系人信息变更
	 * @param contactsChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByExampleData(ContactsChange contactsChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改联系人信息变更
	 * @param contactsChange
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByExampleSelectiveData(ContactsChange contactsChange, Example example);

	/**
	 * @Title:
	 * @Description: 根据contactsChangeId删除联系人信息变更
	 * @param contactsChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int deleteData(ContactsChange contactsChange);

	/**
	 * @Title:
	 * @Description: 根据contactsChangeId集合批量删除联系人信息变更
	 * @param contactsChangeIds
	 * @param contactsChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int deleteDataList(List contactsChangeIds, ContactsChange contactsChange);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除联系人信息变更
	 * @param example
	 * @param contactsChange
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int deleteExampleData(Example example, ContactsChange contactsChange);

	/**
	 * @Title:
	 * @Description: 查询全部联系人信息变更
	 * @return List<ContactsChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	List<ContactsChange> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个联系人信息变更
	 * @param example
	 * @return ContactsChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	ContactsChange selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询联系人信息变更
	 * @param example
	 * @return List<ContactsChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	List<ContactsChange> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contactsChangeId查询联系人信息变更
	 * @param contactsChangeId
	 * @return ContactsChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	ContactsChange selectByPrimaryKey(Object contactsChangeId);

	/**
	 * @Title:
	 * @Description: 分页查询联系人信息变更
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContactsChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	PageInfoExtend<ContactsChange> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询联系人信息变更vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改联系人信息变更
	 * @param contactsChange,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByPrimaryKeyData(ContactsChange contactsChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改联系人信息变更,并进行排他
	 * @param contactsChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByPrimaryKeyDataList(List<ContactsChange> contactsChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改联系人信息变更,并进行排他
	 * @param contactsChange
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ContactsChange contactsChange, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改联系人信息变更,并进行排他
	 * @param contactsChanges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContactsChange> contactsChanges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改联系人信息变更,并进行排他
	 * @param contactsChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByExampleData(ContactsChange contactsChange, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改联系人信息变更,并进行排他
	 * @param contactsChange
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	int updateByExampleSelectiveData(ContactsChange contactsChange, Example example, boolean exclusive);

}

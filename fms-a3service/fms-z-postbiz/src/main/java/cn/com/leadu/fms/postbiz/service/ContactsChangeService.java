package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.ContactsChange;
import cn.com.leadu.fms.pojo.postbiz.vo.contactschange.ContactsChangeVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeSaveVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeModifyVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeDeleteVo;
import cn.com.leadu.fms.postbiz.validator.contactschange.vo.ContactsChangeDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: ContactsChangeService
 * @Description: 联系人信息变更业务层
 * @date 2018-09-01
 */
public interface ContactsChangeService {

	/**
	 * @Title:
	 * @Description: 分页查询联系人信息变更
	 * @param contactsChangeVo
	 * @return PageInfoExtend<ContactsChange>
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	PageInfoExtend<ContactsChange> findContactsChangesByPage(ContactsChangeVo contactsChangeVo);

	/**
	 * @Title:
	 * @Description: 保存联系人信息变更
	 * @param contactsChangeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
    void saveContactsChange(ContactsChangeSaveVo contactsChangeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改联系人信息变更
	 * @param contactsChangeModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	void modifyContactsChange(ContactsChangeModifyVo contactsChangeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contactsChangeId删除联系人信息变更
	 * @param contactsChangeDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	void deleteContactsChange(ContactsChangeDeleteVo contactsChangeDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contactsChangeId集合删除联系人信息变更
	 * @param contactsChangeDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	void deleteContactsChangesByContactsChangeIds(ContactsChangeDeleteListVo contactsChangeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contactsChangeId获取联系人信息变更
	 * @param contactsChangeId
	 * @return ContactsChange
	 * @throws
	 * @author lijunjun
	 * @date 2018-9-1 10:19:21
	 */
	ContactsChange findContactsChangeByContactsChangeId(String contactsChangeId);

}

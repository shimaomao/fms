package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.CstmContactSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.CstmContactModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.CstmContactDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmcontact.vo.CstmContactDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmContactService
 * @Description: 客户联系人信息业务层
 * @date 2018-03-27
 */
public interface CstmContactService {

	/**
	 * @Title:
	 * @Description: 分页查询客户联系人信息
	 * @param cstmContactVo
	 * @return PageInfoExtend<CstmContact>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:44
	 */
	PageInfoExtend<CstmContact> findCstmContactsByPage(CstmContactVo cstmContactVo);

	/**
	 * @Title:
	 * @Description: 保存客户联系人信息
	 * @param cstmContact
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:44
	 */
    void saveCstmContact(List<CstmContact> cstmContact,String applyNo);


	/**
	 * @Title:
	 * @Description: 修改客户联系人信息
	 * @param cstmContactModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:44
	 */
	void modifyCstmContact(CstmContactModifyVo cstmContactModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contactId删除客户联系人信息
	 * @param cstmContactDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:44
	 */
	void deleteCstmContact(CstmContactDeleteVo cstmContactDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contactId集合删除客户联系人信息
	 * @param cstmContactDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:44
	 */
	void deleteCstmContactsByContactIds(CstmContactDeleteListVo cstmContactDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contactId获取客户联系人信息
	 * @param contactId
	 * @return CstmContact
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:44
	 */
	CstmContact findCstmContactByContactId(String contactId);

	/**
	 * 根据订单号得到联系人信息
	 * @param applyNo
	 * @return
	 */
	List<CstmContact> findCstmContactsByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据applyNo更新客户联系人信息
	 * @param cstmContactList
	 * @return CstmContact
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:56:44
	 */
	void  updateCstmContactsByApplyNo(List<CstmContact> cstmContactList,String applyNo);
}

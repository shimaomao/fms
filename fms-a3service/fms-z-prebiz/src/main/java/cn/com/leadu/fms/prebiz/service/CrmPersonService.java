package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.CrmPersonCarrierVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.CrmPersonVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonSaveVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonModifyVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonDeleteVo;
import cn.com.leadu.fms.prebiz.validator.crmperson.vo.CrmPersonDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonService
 * @Description: CRM个人信息业务层
 * @date 2018-05-23
 */
public interface CrmPersonService {

	/**
	 * @Title:
	 * @Description: 分页查询CRM个人信息
	 * @param crmPersonVo
	 * @return PageInfoExtend<CrmPerson>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	PageInfoExtend<CrmPerson> findCrmPersonsByPage(CrmPersonVo crmPersonVo);

	/**
	 * @Title:
	 * @Description: 保存CRM个人信息
	 * @param crmPersonSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
    void saveCrmPerson(CrmPersonSaveVo crmPersonSaveVo);


	/**
	 * @Title:
	 * @Description: 修改CRM个人信息
	 * @param crmPersonModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	void modifyCrmPerson(CrmPersonModifyVo crmPersonModifyVo);

	/**
	 * @Title:
	 * @Description:  通过personId删除CRM个人信息
	 * @param crmPersonDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	void deleteCrmPerson(CrmPersonDeleteVo crmPersonDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过personId集合删除CRM个人信息
	 * @param crmPersonDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	void deleteCrmPersonsByPersonIds(CrmPersonDeleteListVo crmPersonDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据personId获取CRM个人信息
	 * @param personId
	 * @return CrmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	CrmPerson findCrmPersonByPersonId(String personId);

	/**
	 * @Title:
	 * @Description:  根据证件号码获取CRM个人信息
	 * @param certifNo
	 * @return CrmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	CrmPersonCarrierVo findCrmPersonByCertifNo(String certifNo);

	/**
	 * @Title:
	 * @Description: 将前台传入的融资信息转为crm个人信息
	 * @param applyInputVo
	 * @return CstmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	void getCrmPersonFromInputVo(ApplyInputVo applyInputVo);

	/**
	 * validator
	 * @param certifNo
	 * @return
	 */
	CrmPerson findCrmPerByCertifNo(String certifNo);

}

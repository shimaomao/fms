package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyCarrierVo;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyVo;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanySaveVo;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanyModifyVo;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanyDeleteVo;
import cn.com.leadu.fms.prebiz.validator.crmcompany.vo.CrmCompanyDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyService
 * @Description: CRM企业信息业务层
 * @date 2018-05-23
 */
public interface CrmCompanyService {

	/**
	 * @Title:
	 * @Description: 分页查询CRM企业信息
	 * @param crmCompanyVo
	 * @return PageInfoExtend<CrmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	PageInfoExtend<CrmCompanyVo> findCrmCompanysByPage(CrmCompanyVo crmCompanyVo);

	/**
	 * @Title:
	 * @Description: 保存CRM企业信息
	 * @param crmCompanySaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
    void saveCrmCompany(CrmCompanySaveVo crmCompanySaveVo);


	/**
	 * @Title:
	 * @Description: 修改CRM企业信息
	 * @param crmCompanyModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	void modifyCrmCompany(CrmCompanyModifyVo crmCompanyModifyVo);

	/**
	 * @Title:
	 * @Description:  通过companyId删除CRM企业信息
	 * @param crmCompanyDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	void deleteCrmCompany(CrmCompanyDeleteVo crmCompanyDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过companyId集合删除CRM企业信息
	 * @param crmCompanyDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	void deleteCrmCompanysByCompanyIds(CrmCompanyDeleteListVo crmCompanyDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据companyId获取CRM企业信息
	 * @param companyId
	 * @return CrmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	CrmCompany findCrmCompanyByCompanyId(String companyId);

	/**
	 * @Title:
	 * @Description:  根据证件号获取CRM企业信息
	 * @param socialCertifNo
	 * @return CrmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 18:09:00
	 */
	CrmCompanyCarrierVo findCrmCompanyByCertifNo(String socialCertifNo);

	/**
	 * @Title:
	 * @Description: 将前台传入的融资信息转为crm企业信息
	 * @param applyInputVo
	 * @return CstmPerson
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-23 17:28:08
	 */
	void getCrmCompFromInputVo(ApplyInputVo applyInputVo);

	/**
	 * validator
	 * @param certifNo
	 * @return
	 */
	CrmCompany findCrmCompByCertifNo(String certifNo);

}

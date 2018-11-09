package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanySaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanyModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanyDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmcompany.vo.CstmCompanyDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmCompanyService
 * @Description: 客户企业基本信息业务层
 * @date 2018-03-27
 */
public interface CstmCompanyService {

	/**
	 * @Title:
	 * @Description: 分页查询客户企业基本信息
	 * @param cstmCompanyVo
	 * @return PageInfoExtend<CstmCompany>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	PageInfoExtend<CstmCompany> findCstmCompanysByPage(CstmCompanyVo cstmCompanyVo);

	/**
	 * @Title:
	 * @Description: 保存客户企业基本信息
	 * @param cstmCompanySaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
    void saveCstmCompany(CstmCompanySaveVo cstmCompanySaveVo,String applyNo);


	/**
	 * @Title:
	 * @Description: 修改客户企业基本信息
	 * @param cstmCompanyModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	void modifyCstmCompany(CstmCompanyModifyVo cstmCompanyModifyVo);

	/**
	 * @Title:
	 * @Description:  通过cstmCompanyId删除客户企业基本信息
	 * @param cstmCompanyDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	void deleteCstmCompany(CstmCompanyDeleteVo cstmCompanyDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过cstmCompanyId集合删除客户企业基本信息
	 * @param cstmCompanyDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	void deleteCstmCompanysByCstmCompanyIds(CstmCompanyDeleteListVo cstmCompanyDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据cstmCompanyId获取客户企业基本信息
	 * @param cstmCompanyId
	 * @return CstmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	CstmCompany findCstmCompanyByCstmCompanyId(String cstmCompanyId);

	/**
	 * 根据订单号得到企业信息
	 * @param applyNo
	 * @return
	 */
	 CstmCompany findCstmCompanyByApplyNo(String applyNo);

	/** 
	* @Description: 根据socialCertifNo获取所有企业信息,排除applyNo
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/15 11:41
	*/ 
	List<CstmCompany> findCstmCompanyListBySocialCertifNo(String socialCertifNo,String applyNo);
	/**
	 * @Title:
	 * @Description:  根据applyNo更新客户企业基本信息
	 * @param cstmCompany
	 * @return CstmCompany
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-27 11:11:47
	 */
	void updateCstmCompanyByApplyNo(CstmCompany cstmCompany,String applyNo);


}

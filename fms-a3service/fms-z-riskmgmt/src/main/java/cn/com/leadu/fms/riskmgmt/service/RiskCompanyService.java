package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskCompany;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskcompany.RiskCompanyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanyDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanyDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanyModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanySaveVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskCompanyService
 * @Description: 企业风险信息业务层
 * @date 2018-06-04
 */
public interface RiskCompanyService {

	/**
	 * @Title:
	 * @Description: 分页查询企业风险信息
	 * @param riskCompanyVo
	 * @return PageInfoExtend<RiskCompany>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	PageInfoExtend<RiskCompany> findRiskCompanysByPage(RiskCompanyVo riskCompanyVo);

	/**
	 * @Title:
	 * @Description: 保存企业风险信息
	 * @param riskCompanySaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
    void saveRiskCompany(RiskCompanySaveVo riskCompanySaveVo);


	/**
	 * @Title:
	 * @Description: 修改企业风险信息
	 * @param riskCompanyModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	void modifyRiskCompany(RiskCompanyModifyVo riskCompanyModifyVo);

	/**
	 * @Title:
	 * @Description:  通过riskCompanyId删除企业风险信息
	 * @param riskCompanyDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	void deleteRiskCompany(RiskCompanyDeleteVo riskCompanyDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过riskCompanyId集合删除企业风险信息
	 * @param riskCompanyDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	void deleteRiskCompanysByRiskCompanyIds(RiskCompanyDeleteListVo riskCompanyDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据riskCompanyId获取企业风险信息
	 * @param riskCompanyId
	 * @return RiskCompany
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:44
	 */
	RiskCompany findRiskCompanyByRiskCompanyId(String riskCompanyId);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取企业风险信息
	 * @param applyNo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	List<RiskCompany> findRiskCompanyListByApplyNo(String applyNo);
}

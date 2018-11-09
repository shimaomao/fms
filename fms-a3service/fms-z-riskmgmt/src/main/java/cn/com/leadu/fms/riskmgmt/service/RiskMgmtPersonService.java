package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskmgmtperson.RiskMgmtPersonVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author liujinge
 * @ClassName: RiskMgmtPersonService
 * @Description: 风控个人信息业务层
 * @date 2018-06-04
 */
public interface RiskMgmtPersonService {

	/**
	 * @Title:
	 * @Description: 分页查询风控个人信息
	 * @param riskMgmtPersonVo
	 * @return PageInfoExtend<RiskMgmtPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	PageInfoExtend<RiskMgmtPerson> findRiskMgmtPersonsByPage(RiskMgmtPersonVo riskMgmtPersonVo);

	/**
	 * @Title:
	 * @Description: 保存风控个人信息
	 * @param riskMgmtPersonSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
    void saveRiskMgmtPerson(RiskMgmtPersonSaveVo riskMgmtPersonSaveVo);


	/**
	 * @Title:
	 * @Description: 修改风控个人信息
	 * @param riskMgmtPersonModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	void modifyRiskMgmtPerson(RiskMgmtPersonModifyVo riskMgmtPersonModifyVo);

	/**
	 * @Title:
	 * @Description:  通过riskMgmtPersonId删除风控个人信息
	 * @param riskMgmtPersonDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	void deleteRiskMgmtPerson(RiskMgmtPersonDeleteVo riskMgmtPersonDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过riskMgmtPersonId集合删除风控个人信息
	 * @param riskMgmtPersonDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	void deleteRiskMgmtPersonsByRiskMgmtPersonIds(RiskMgmtPersonDeleteListVo riskMgmtPersonDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据riskMgmtPersonId获取风控个人信息
	 * @param riskMgmtPersonId
	 * @return RiskMgmtPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	RiskMgmtPerson findRiskMgmtPersonByRiskMgmtPersonId(String riskMgmtPersonId);
	/**
	 * @Title:
	 * @Description:  根据applyNo获取风控个人信息
	 * @param applyNo
	 * @return RiskMgmtPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
    RiskMgmtPerson findRiskMgmtPersonByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据certifNo获取主贷人的风控信息
	 * @param certifNo
	 * @return RiskMgmtPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	RiskMgmtPerson findRiskMgmtPersonByMain(String certifNo,String applyNo);
}

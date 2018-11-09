package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskmgmtcomp.RiskMgmtCompVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompSaveVo;

/**
 * @author liujinge
 * @ClassName: RiskMgmtCompService
 * @Description: 风控企业信息业务层
 * @date 2018-06-04
 */
public interface RiskMgmtCompService {

	/**
	 * @Title:
	 * @Description: 分页查询风控企业信息
	 * @param riskMgmtCompVo
	 * @return PageInfoExtend<RiskMgmtComp>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	PageInfoExtend<RiskMgmtComp> findRiskMgmtCompsByPage(RiskMgmtCompVo riskMgmtCompVo);

	/**
	 * @Title:
	 * @Description: 保存风控企业信息
	 * @param riskMgmtCompSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
    void saveRiskMgmtComp(RiskMgmtCompSaveVo riskMgmtCompSaveVo);


	/**
	 * @Title:
	 * @Description: 修改风控企业信息
	 * @param riskMgmtCompModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	void modifyRiskMgmtComp(RiskMgmtCompModifyVo riskMgmtCompModifyVo);

	/**
	 * @Title:
	 * @Description:  通过riskMgmtCompId删除风控企业信息
	 * @param riskMgmtCompDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	void deleteRiskMgmtComp(RiskMgmtCompDeleteVo riskMgmtCompDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过riskMgmtCompId集合删除风控企业信息
	 * @param riskMgmtCompDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	void deleteRiskMgmtCompsByRiskMgmtCompIds(RiskMgmtCompDeleteListVo riskMgmtCompDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据riskMgmtCompId获取风控企业信息
	 * @param riskMgmtCompId
	 * @return RiskMgmtComp
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:53
	 */
	RiskMgmtComp findRiskMgmtCompByRiskMgmtCompId(String riskMgmtCompId);
	/**
	 * @Title:
	 * @Description:  根据applyNo获取风控个人信息
	 * @param applyNo
	 * @return RiskMgmtComp
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	RiskMgmtComp findRiskMgmtCompByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description:  根据certifNo获取主贷人的风控信息
	 * @param certifNo
	 * @return RiskMgmtComp
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:07
	 */
	RiskMgmtComp findRiskMgmtCompByMain(String certifNo,String applyNo);
}

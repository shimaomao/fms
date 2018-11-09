package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskmgmtguarantee.RiskMgmtGuaranteeVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeSaveVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtGuaranteeService
 * @Description: 风控担保人信息业务层
 * @date 2018-06-04
 */
public interface RiskMgmtGuaranteeService {

	/**
	 * @Title:
	 * @Description: 分页查询风控担保人信息
	 * @param riskMgmtGuaranteeVo
	 * @return PageInfoExtend<RiskMgmtGuarantee>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	PageInfoExtend<RiskMgmtGuarantee> findRiskMgmtGuaranteesByPage(RiskMgmtGuaranteeVo riskMgmtGuaranteeVo);

	/**
	 * @Title:
	 * @Description: 保存风控担保人信息
	 * @param riskMgmtGuaranteeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
    void saveRiskMgmtGuarantee(RiskMgmtGuaranteeSaveVo riskMgmtGuaranteeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改风控担保人信息
	 * @param riskMgmtGuaranteeModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	void modifyRiskMgmtGuarantee(RiskMgmtGuaranteeModifyVo riskMgmtGuaranteeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过riskMgmtGuaranteeId删除风控担保人信息
	 * @param riskMgmtGuaranteeDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	void deleteRiskMgmtGuarantee(RiskMgmtGuaranteeDeleteVo riskMgmtGuaranteeDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过riskMgmtGuaranteeId集合删除风控担保人信息
	 * @param riskMgmtGuaranteeDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	void deleteRiskMgmtGuaranteesByRiskMgmtGuaranteeIds(RiskMgmtGuaranteeDeleteListVo riskMgmtGuaranteeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据riskMgmtGuaranteeId获取风控担保人信息
	 * @param riskMgmtGuaranteeId
	 * @return RiskMgmtGuarantee
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	RiskMgmtGuarantee findRiskMgmtGuaranteeByRiskMgmtGuaranteeId(String riskMgmtGuaranteeId);


	/**
	 * @Title:
	 * @Description:  根据applyNo获取风控担保人信息
	 * @param applyNo
	 * @return List<RiskMgmtGuarantee>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:04:28
	 */
	List<RiskMgmtGuarantee> findRiskMgmtGuaranteeListByApplyNo(String applyNo);


}

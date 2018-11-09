package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk.RiskTelchkVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkSaveVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkService
 * @Description: 风控电核信息业务层
 * @date 2018-06-04
 */
public interface RiskTelchkService {

	/**
	 * @Title:
	 * @Description: 分页查询风控电核信息
	 * @param riskTelchkVo
	 * @return PageInfoExtend<RiskTelchk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:45
	 */
	PageInfoExtend<RiskTelchk> findRiskTelchksByPage(RiskTelchkVo riskTelchkVo);

	/**
	 * @Title:
	 * @Description: 保存风控电核信息
	 * @param riskTelchkSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:45
	 */
    void saveRiskTelchk(RiskTelchkSaveVo riskTelchkSaveVo);


	/**
	 * @Title:
	 * @Description: 修改风控电核信息
	 * @param riskTelchkModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:45
	 */
	void modifyRiskTelchk(RiskTelchkModifyVo riskTelchkModifyVo);

	/**
	 * @Title:
	 * @Description:  通过riskTelchkId删除风控电核信息
	 * @param riskTelchkDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:45
	 */
	void deleteRiskTelchk(RiskTelchkDeleteVo riskTelchkDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过riskTelchkId集合删除风控电核信息
	 * @param riskTelchkDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:45
	 */
	void deleteRiskTelchksByRiskTelchkIds(RiskTelchkDeleteListVo riskTelchkDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据riskTelchkId获取风控电核信息
	 * @param riskTelchkId
	 * @return RiskTelchk
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:45
	 */
	RiskTelchk findRiskTelchkByRiskTelchkId(String riskTelchkId);

	/**
	 * @Title:
	 * @Description:  根据ApplyNo获取风控电核信息
	 * @param applyNo
	 * @return RiskTelchk
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:03:45
	 */
	List<RiskTelchkVo> findRiskTelchkByApplyNo(String applyNo);
}

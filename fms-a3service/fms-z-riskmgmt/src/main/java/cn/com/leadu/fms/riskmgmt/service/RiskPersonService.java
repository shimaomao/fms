package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskPerson;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskperson.RiskPersonVo;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonSaveVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskPersonService
 * @Description: 个人风险信息业务层
 * @date 2018-06-04
 */
public interface RiskPersonService {

	/**
	 * @Title:
	 * @Description: 分页查询个人风险信息
	 * @param riskPersonVo
	 * @return PageInfoExtend<RiskPerson>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	PageInfoExtend<RiskPerson> findRiskPersonsByPage(RiskPersonVo riskPersonVo);

	/**
	 * @Title:
	 * @Description: 保存个人风险信息
	 * @param riskPersonSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
    void saveRiskPerson(RiskPersonSaveVo riskPersonSaveVo);


	/**
	 * @Title:
	 * @Description: 修改个人风险信息
	 * @param riskPersonModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	void modifyRiskPerson(RiskPersonModifyVo riskPersonModifyVo);

	/**
	 * @Title:
	 * @Description:  通过riskPersonId删除个人风险信息
	 * @param riskPersonDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	void deleteRiskPerson(RiskPersonDeleteVo riskPersonDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过riskPersonId集合删除个人风险信息
	 * @param riskPersonDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	void deleteRiskPersonsByRiskPersonIds(RiskPersonDeleteListVo riskPersonDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据riskPersonId获取个人风险信息
	 * @param riskPersonId
	 * @return RiskPerson
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	RiskPerson findRiskPersonByRiskPersonId(String riskPersonId);


	/**
	 * @Title:
	 * @Description:  根据applyNo获取个人风险信息
	 * @param applyNo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	List<RiskPerson> findRiskPersonListByApplyNo(String applyNo);


}

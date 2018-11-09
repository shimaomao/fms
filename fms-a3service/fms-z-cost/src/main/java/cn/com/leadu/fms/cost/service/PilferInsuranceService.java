package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceSaveVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceModifyVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceDeleteVo;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.PilferInsuranceDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceService
 * @Description: 盗抢险信息业务层
 * @date 2018-05-31
 */
public interface PilferInsuranceService {

	/**
	 * @Title:
	 * @Description: 分页查询盗抢险信息
	 * @param pilferInsuranceVo
	 * @return PageInfoExtend<PilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	PageInfoExtend<PilferInsurance> findPilferInsurancesByPage(PilferInsuranceVo pilferInsuranceVo);

	/**
	 * @Title:
	 * @Description: 保存盗抢险信息
	 * @param pilferInsuranceSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
    void savePilferInsurance(PilferInsuranceSaveVo pilferInsuranceSaveVo);


	/**
	 * @Title:
	 * @Description: 修改盗抢险信息
	 * @param pilferInsuranceModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	void modifyPilferInsurance(PilferInsuranceModifyVo pilferInsuranceModifyVo);

	/**
	 * @Title:
	 * @Description:  通过pilferInsuranceId删除盗抢险信息
	 * @param pilferInsuranceDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	void deletePilferInsurance(PilferInsuranceDeleteVo pilferInsuranceDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过pilferInsuranceId集合删除盗抢险信息
	 * @param pilferInsuranceDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	void deletePilferInsurancesByPilferInsuranceIds(PilferInsuranceDeleteListVo pilferInsuranceDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据pilferInsuranceId获取盗抢险信息
	 * @param pilferInsuranceId
	 * @return PilferInsurance
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:34:24
	 */
	PilferInsurance findPilferInsuranceByPilferInsuranceId(String pilferInsuranceId);

	/** 
	* @Description:  查询盗抢险月结信息一览
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/17 21:18
	*/ 
	PageInfoExtend<PilferInsuranceVo> findPilferInsuranceMonthlysVosListByPage(PilferInsuranceVo pilferInsuranceVo);

	/** 
	* @Description: 申请，审批页面查询盗抢险月结信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/31 18:20
	*/ 
	PageInfoExtend<PilferInsuranceVo> findPilferInsuranceMonthlysVos(PilferInsuranceVo pilferInsuranceVo);

	/**
	 * @Title:
	 * @Description: 根据合同号获取盗抢险信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	PilferInsuranceVo findPilferInsuranceVoByContNo(String contNo);

}

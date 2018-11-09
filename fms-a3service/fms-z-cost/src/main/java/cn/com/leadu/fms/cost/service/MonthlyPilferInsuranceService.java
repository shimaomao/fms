package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.MonthlyPilferInsuranceVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceSaveVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceModifyVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceDeleteVo;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.MonthlyPilferInsuranceDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceService
 * @Description: 盗抢险月结任务信息业务层
 * @date 2018-05-31
 */
public interface MonthlyPilferInsuranceService {

	/**
	 * @Title:
	 * @Description: 分页查询盗抢险月结任务信息
	 * @param monthlyPilferInsuranceVo
	 * @return PageInfoExtend<MonthlyPilferInsurance>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	PageInfoExtend<MonthlyPilferInsurance> findMonthlyPilferInsurancesByPage(MonthlyPilferInsuranceVo monthlyPilferInsuranceVo);

	/**
	 * @Title:
	 * @Description: 保存盗抢险月结任务信息
	 * @param monthlyPilferInsuranceSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
    void saveMonthlyPilferInsurance(MonthlyPilferInsuranceSaveVo monthlyPilferInsuranceSaveVo);

	/** 
	* @Description: 保存盗抢险月结任务信息，包括盗抢险信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/31 20:43
	*/ 
	void saveMonthlyPilferInsuranceWithPI(MonthlyPilferInsuranceVo monthlyPilferInsuranceVo);


	/**
	 * @Title:
	 * @Description: 修改盗抢险月结任务信息
	 * @param monthlyPilferInsuranceModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	void modifyMonthlyPilferInsurance(MonthlyPilferInsuranceModifyVo monthlyPilferInsuranceModifyVo);

	/**
	 * @Title:
	 * @Description:  通过monthlyPilferInsuranceId删除盗抢险月结任务信息
	 * @param monthlyPilferInsuranceDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	void deleteMonthlyPilferInsurance(MonthlyPilferInsuranceDeleteVo monthlyPilferInsuranceDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过monthlyPilferInsuranceId集合删除盗抢险月结任务信息
	 * @param monthlyPilferInsuranceDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	void deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds(MonthlyPilferInsuranceDeleteListVo monthlyPilferInsuranceDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据monthlyPilferInsuranceId获取盗抢险月结任务信息
	 * @param monthlyPilferInsuranceId
	 * @return MonthlyPilferInsurance
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-31 15:47:58
	 */
	MonthlyPilferInsurance findMonthlyPilferInsuranceByMonthlyPilferInsuranceId(String monthlyPilferInsuranceId);

	/** 
	* @Description:  根据monthlyPilferInsuranceNo获取盗抢险月结任务信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/1 11:41
	*/ 
	MonthlyPilferInsurance findMonthlyPilferInsuranceByPilferInsuranceNo(String monthlyPilferInsuranceNo);

	/**
	 * @Title:
	 * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息(含附件)
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	MonthlyPilferInsuranceVo findMonthlyPilferInsuranceVoByPilferInsuranceNo(String monthlyPilferInsuranceNo);

	/** 
	* @Description: 审批操作
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/1 11:54
	*/ 
    void approval(PilferInsuranceApproveVo pilferInsuranceApproveVo);
}

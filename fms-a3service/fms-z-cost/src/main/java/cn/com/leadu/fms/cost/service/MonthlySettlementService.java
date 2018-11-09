package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlement.MonthlySettlementVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementSaveVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementModifyVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementDeleteVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementService
 * @Description: gps月结任务表业务层
 * @date 2018-05-28
 */
public interface MonthlySettlementService {

	/**
	 * @Title:
	 * @Description: 分页查询gps月结任务表
	 * @param monthlySettlementVo
	 * @return PageInfoExtend<MonthlySettlement>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	PageInfoExtend<MonthlySettlement> findMonthlySettlementsByPage(MonthlySettlementVo monthlySettlementVo);

	/**
	 * @Title:
	 * @Description: 保存gps月结任务表
	 * @param monthlySettlementSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
    void saveMonthlySettlement(MonthlySettlementSaveVo monthlySettlementSaveVo);

	/** 
	* @Description: 月结申请
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/29 10:16
	*/ 
    void saveMonthlySettlementWithGps(MonthlySettlementVo monthlySettlementVo);


	/**
	 * @Title:
	 * @Description: 修改gps月结任务表
	 * @param monthlySettlementModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	void modifyMonthlySettlement(MonthlySettlementModifyVo monthlySettlementModifyVo);

	/**
	 * @Title:
	 * @Description:  通过monthlySettlementId删除gps月结任务表
	 * @param monthlySettlementDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	void deleteMonthlySettlement(MonthlySettlementDeleteVo monthlySettlementDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过monthlySettlementId集合删除gps月结任务表
	 * @param monthlySettlementDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	void deleteMonthlySettlementsByMonthlySettlementIds(MonthlySettlementDeleteListVo monthlySettlementDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据monthlySettlementId获取gps月结任务表
	 * @param monthlySettlementId
	 * @return MonthlySettlement
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	MonthlySettlement findMonthlySettlementByMonthlySettlementId(String monthlySettlementId);

	/**
	 * @Title:
	 * @Description:  根据monthlySettlementNo获取gps月结任务表
	 * @param monthlySettlementNo
	 * @return MonthlySettlement
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-28 14:25:41
	 */
	MonthlySettlement findMonthlySettlementBySettlementNo(String monthlySettlementNo);

	/**
	 * @Title:
	 * @Description: 根据monthlySettlementNo获取gps月结任务表(含附件)
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	MonthlySettlementVo findMonthlySettlementVoBySettlementNo(String monthlySettlementNo);

}

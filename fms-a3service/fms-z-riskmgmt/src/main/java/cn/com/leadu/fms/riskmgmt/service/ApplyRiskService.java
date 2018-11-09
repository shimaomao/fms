package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;

/**
 * @author liujinge
 * @ClassName: ApplyRiskService
 * @Description:
 * @date 2018-06-04
 */
public interface ApplyRiskService {
	/**
	 * @Title:
	 * @Description: 风控初审画面初始数据
	 * @param applyNo
	 * @return ApplyRiskVo
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
	ApplyRiskVo findApplyRiskInit(String applyNo,String flag);

	/** 
	* @Description: 保存风控数据
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/6 15:34
	*/ 
	void saveApplyRiskInit(ApplyRiskVo applyRiskVo);

	/** 
	* @Description: 退回 
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/23 14:15
	*/ 
    void backApplyRisk(ApplyRiskVo applyRiskVo);

	/**
	* @Description: 退回到业务员
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/8/24 10:35
	*/
	void backToApply(ApplyRiskVo applyRiskVo);
}

package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.contconfirmbef.ContConfirmBefVo;

/**
 * @author liujinge
 * @ClassName: ContConfirmBefService
 * @Description: 合同生成前确认业务层
 * @date 2018-03-23
 */
public interface ContConfirmBefService {

	/**
	 * @Title:
	 * @Description: 合同生成前确认
	 * @param contConfirmBefVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
    void confirm(ContConfirmBefVo contConfirmBefVo);

	/**
	* @Description: 退回到申请
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/9/15 14:55
	*/
    void returnDealer(ContConfirmBefVo contConfirmBefVo);
}

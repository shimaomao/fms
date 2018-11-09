package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedSaveVo;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedModifyVo;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedDeleteVo;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedService
 * @Description: 财务还款计划业务层
 * @date 2018-05-12
 */
public interface FinRepaySkedService {

	/**
	 * @Title:
	 * @Description: 分页查询财务还款计划
	 * @param finRepaySkedVo
	 * @return PageInfoExtend<FinRepaySked>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	PageInfoExtend<ContRepaySkedVo> findFinRepaySkedsByPage(FinRepaySkedVo finRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 保存财务还款计划
	 * @param finRepaySkedSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
    void saveFinRepaySked(FinRepaySkedSaveVo finRepaySkedSaveVo);


	/**
	 * @Title:
	 * @Description: 修改财务还款计划
	 * @param finRepaySkedModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	void modifyFinRepaySked(FinRepaySkedModifyVo finRepaySkedModifyVo);

	/**
	 * @Title:
	 * @Description:  通过finRepaySkedId删除财务还款计划
	 * @param finRepaySkedDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	void deleteFinRepaySked(FinRepaySkedDeleteVo finRepaySkedDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过finRepaySkedId集合删除财务还款计划
	 * @param finRepaySkedDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	void deleteFinRepaySkedsByFinRepaySkedIds(FinRepaySkedDeleteListVo finRepaySkedDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据finRepaySkedId获取财务还款计划
	 * @param finRepaySkedId
	 * @return FinRepaySked
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	FinRepaySked findFinRepaySkedByFinRepaySkedId(String finRepaySkedId);

	/**
	 * @Title:
	 * @Description: 开具发票
	 * @param contRepaySkedVos
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-8-21 16:40:57
	 */
	void finRepaySkedInvoice(List<ContRepaySkedVo> contRepaySkedVos);

	/**
	* @Description: 批量修改开票属性
	* @param:
	* @return:
	* @Author: yangyiquan
	* @Date: 2018/9/25 11:48
	*/
	void editInvoiceProp(FinRepaySkedVo finRepaySkedVo);

}

package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueSaveVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueModifyVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueDeleteVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContOverdueService
 * @Description: 还款逾期罚息业务层
 * @date 2018-05-08
 */
public interface ContOverdueService {

	/**
	 * @Title:
	 * @Description: 分页查询还款逾期罚息
	 * @param contOverdueVo
	 * @return PageInfoExtend<ContOverdue>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	PageInfoExtend<ContOverdue> findContOverduesByPage(ContOverdueVo contOverdueVo);

	/**
	 * @Title:
	 * @Description: 保存还款逾期罚息
	 * @param contOverdueSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
    void saveContOverdue(ContOverdueSaveVo contOverdueSaveVo);


	/**
	 * @Title:
	 * @Description: 修改还款逾期罚息
	 * @param contOverdueModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	void modifyContOverdue(ContOverdueModifyVo contOverdueModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contOverdueId删除还款逾期罚息
	 * @param contOverdueDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	void deleteContOverdue(ContOverdueDeleteVo contOverdueDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contOverdueId集合删除还款逾期罚息
	 * @param contOverdueDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	void deleteContOverduesByContOverdueIds(ContOverdueDeleteListVo contOverdueDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contOverdueId获取还款逾期罚息
	 * @param contOverdueId
	 * @return ContOverdue
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	ContOverdue findContOverdueByContOverdueId(String contOverdueId);

	/** 
	* @Description: 查询逾期罚息表中，扣款状态<>成功 的剩余罚息金额合计
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 14:46
	*/ 
	BigDecimal findOverdueInterestSum(String contNo);

	/**
	 * @Description: 根据合同号查找总罚息
	 * @param:
	 * @return:BigDecimal
	 * @Author: ningyangyang
	 * @Date: 2018/5/23 14:46
	 */
	BigDecimal findContOverdueAmountByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 根据合同号查询逾期罚息表
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	List<ContOverdueVo> findContOverdueByCont(String contNo);
}

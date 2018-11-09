package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeSaveVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeModifyVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeDeleteVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ContChargeService
 * @Description: 财务待收款业务层
 * @date 2018-06-01
 */
public interface ContChargeService {

	/**
	 * @Title:
	 * @Description: 分页查询财务待收款
	 * @param contChargeVo
	 * @return PageInfoExtend<ContCharge>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:47
	 */
	PageInfoExtend<ContCharge> findContChargesByPage(ContChargeVo contChargeVo);

	/**
	 * @Title:
	 * @Description: 保存财务待收款
	 * @param contChargeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:47
	 */
    void saveContCharge(ContChargeSaveVo contChargeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改财务待收款
	 * @param contChargeModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:47
	 */
	void modifyContCharge(ContChargeModifyVo contChargeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过contChargeId删除财务待收款
	 * @param contChargeDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:47
	 */
	void deleteContCharge(ContChargeDeleteVo contChargeDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过contChargeId集合删除财务待收款
	 * @param contChargeDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:47
	 */
	void deleteContChargesByContChargeIds(ContChargeDeleteListVo contChargeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据contChargeId获取财务待收款
	 * @param contChargeId
	 * @return ContCharge
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-1 9:55:47
	 */
	ContCharge findContChargeByContChargeId(String contChargeId);

	/** 
	* @Description: 根据 业务类型 业务号查询待收款数据
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/13 11:05
	*/ 
	List<ContCharge> fingContChargeListByBizIdAndBizType(String chargeBizId,String chargeBizType);

	/** 
	* @Description: 根据业务类型和业务号查询待收款数据和收款数据
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/28 10:56
	*/
	List<ContChargeReceiptVo> fingContChargeAndReceiptByBizIdAndBizType(String chargeBizId, String chargeBizType,String chargeFund);
}

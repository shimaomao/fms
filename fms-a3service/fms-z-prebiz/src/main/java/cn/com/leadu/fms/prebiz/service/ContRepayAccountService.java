package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountVo;
import cn.com.leadu.fms.prebiz.validator.contrepayaccount.vo.ContRepayAccountModifyVo;

/**
 * @author liujinge
 * @ClassName: ContRepayAccountService
 * @Description: 融资合同还款信息业务层
 * @date 2018-03-23
 */
public interface ContRepayAccountService {

	/**
	 * @Title:
	 * @Description: 分页查询融资合同还款信息
	 * @param contRepayAccountVo
	 * @return PageInfoExtend<ContRepayAccount>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	PageInfoExtend<ContRepayAccount> findContRepayAccountsByPage(ContRepayAccountVo contRepayAccountVo);



	/**
	 * @Title:
	 * @Description:  根据repayAccId获取融资合同还款信息
	 * @param repayAccId
	 * @return ContRepayAccount
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:15
	 */
	ContRepayAccount findContRepayAccountByRepayAccId(String repayAccId);

	/**
	 * @Title:
	 * @Description:  保存融资合同还款信息
	 * @param contRepayAccountVo
	 * @return ContRepayAccount
	 * @throws
	 * @author huchengjao
	 * @date 2018-4-1 18:48:15
	 */
	int saveContRepayAccount(ContRepayAccountVo contRepayAccountVo);

	/**
	 * @Title:
	 * @Description:  根据合同号取得融资合同还款信息
	 * @param contNo
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:16
	 */
	ContRepayAccount findContRepayAccountByContNo(String contNo);

	/** 
	* @Description: 动态修改客户还款信息
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/9 17:58
	*/ 
	int modifyContRepayAccount(ContRepayAccountModifyVo contRepayAccountModifyVo);

	/**
	 * @Description: 动态修改客户还款信息(通过contRepayAccountVo)，生成合同时使用
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/9 17:58
	 */
	int modifyContRepayAccountByVo(ContRepayAccountVo contRepayAccountVo);

	/** 
	* @Description: 分页查询客户信息一览
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/8 18:27
	*/ 
	PageInfoExtend<ContRepayAccountListVo> findContRepayAccountListByPage(ContRepayAccountListVo contRepayAccountListVo);
}

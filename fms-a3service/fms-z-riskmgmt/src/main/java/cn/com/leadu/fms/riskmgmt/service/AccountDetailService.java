package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetail;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetail.AccountDetailVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailSaveVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailService
 * @Description: 银行流水业务层
 * @date 2018-06-04
 */
public interface AccountDetailService {

	/**
	 * @Title:
	 * @Description: 分页查询银行流水
	 * @param accountDetailVo
	 * @return PageInfoExtend<AccountDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	PageInfoExtend<AccountDetail> findAccountDetailsByPage(AccountDetailVo accountDetailVo);

	/**
	 * @Title:
	 * @Description: 保存银行流水
	 * @param accountDetailSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
    void saveAccountDetail(AccountDetailSaveVo accountDetailSaveVo);


	/**
	 * @Title:
	 * @Description: 修改银行流水
	 * @param accountDetailModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	void modifyAccountDetail(AccountDetailModifyVo accountDetailModifyVo);

	/**
	 * @Title:
	 * @Description:  通过accountDetailId删除银行流水
	 * @param accountDetailDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	void deleteAccountDetail(AccountDetailDeleteVo accountDetailDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过accountDetailId集合删除银行流水
	 * @param accountDetailDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	void deleteAccountDetailsByAccountDetailIds(AccountDetailDeleteListVo accountDetailDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据accountDetailId获取银行流水
	 * @param accountDetailId
	 * @return AccountDetail
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:40
	 */
	AccountDetail findAccountDetailByAccountDetailId(String accountDetailId);

	/**
	 * @Title:
	 * @Description:  根据applyNo获取银行账户流水信息
	 * @param applyNo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:05:15
	 */
	List<AccountDetailVo> findAccountDetailVoListByApplyNo(String applyNo);
}

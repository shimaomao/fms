package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetaillist.AccountDetailListVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListSaveVo;

/**
 * @author liujinge
 * @ClassName: AccountDetailListService
 * @Description: 银行流水明细业务层
 * @date 2018-06-04
 */
public interface AccountDetailListService {

	/**
	 * @Title:
	 * @Description: 分页查询银行流水明细
	 * @param accountDetailListVo
	 * @return PageInfoExtend<AccountDetailList>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
	PageInfoExtend<AccountDetailList> findAccountDetailListsByPage(AccountDetailListVo accountDetailListVo);

	/**
	 * @Title:
	 * @Description: 保存银行流水明细
	 * @param accountDetailListSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
    void saveAccountDetailList(AccountDetailListSaveVo accountDetailListSaveVo);


	/**
	 * @Title:
	 * @Description: 修改银行流水明细
	 * @param accountDetailListModifyVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
	void modifyAccountDetailList(AccountDetailListModifyVo accountDetailListModifyVo);

	/**
	 * @Title:
	 * @Description:  通过accountDetailListId删除银行流水明细
	 * @param accountDetailListDeleteVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
	void deleteAccountDetailList(AccountDetailListDeleteVo accountDetailListDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过accountDetailListId集合删除银行流水明细
	 * @param accountDetailListDeleteListVo
	 * @return
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
	void deleteAccountDetailListsByAccountDetailListIds(AccountDetailListDeleteListVo accountDetailListDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据accountDetailListId获取银行流水明细
	 * @param accountDetailListId
	 * @return AccountDetailList
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:57
	 */
	AccountDetailList findAccountDetailListByAccountDetailListId(String accountDetailListId);

}

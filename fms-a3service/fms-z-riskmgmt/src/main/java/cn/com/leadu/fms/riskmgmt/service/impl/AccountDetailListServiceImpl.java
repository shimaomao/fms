package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.riskmgmt.service.AccountDetailListService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.AccountDetailListRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetaillist.AccountDetailListVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo.AccountDetailListDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author liujinge
 * @ClassName: AccountDetailListService
 * @Description: 银行流水明细业务实现层
 * @date 2018-06-04
 */
@Service
public class AccountDetailListServiceImpl implements AccountDetailListService {

    /**
     * @Fields  : 银行流水明细repository
     */
    @Autowired
    private AccountDetailListRepository accountDetailListRepository;

    /**
     * @Title:
     * @Description: 分页查询银行流水明细
     * @param accountDetailListVo
     * @return PageInfoExtend<AccountDetailList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    public PageInfoExtend<AccountDetailList> findAccountDetailListsByPage(AccountDetailListVo accountDetailListVo){
        Example example = SqlUtil.newExample(AccountDetailList.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<AccountDetailList> pageInfo = accountDetailListRepository.selectListByExamplePage(example,accountDetailListVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存银行流水明细
     * @param accountDetailListSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    public void saveAccountDetailList(AccountDetailListSaveVo accountDetailListSaveVo){
        accountDetailListRepository.insertData(accountDetailListSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改银行流水明细
     * @param accountDetailListModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    public void modifyAccountDetailList(AccountDetailListModifyVo accountDetailListModifyVo){
        accountDetailListRepository.updateByPrimaryKeySelectiveData(accountDetailListModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过accountDetailListId删除银行流水明细
     * @param accountDetailListDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    public void deleteAccountDetailList(AccountDetailListDeleteVo accountDetailListDeleteVo){
        accountDetailListRepository.deleteData(accountDetailListDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过accountDetailListId集合删除银行流水明细
     * @param accountDetailListDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    public void deleteAccountDetailListsByAccountDetailListIds(AccountDetailListDeleteListVo accountDetailListDeleteListVo){
        accountDetailListRepository.deleteDataList(accountDetailListDeleteListVo.getAccountDetailListIds(),accountDetailListDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据accountDetailListId获取银行流水明细
     * @param accountDetailListId
     * @return AccountDetailList
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    public AccountDetailList findAccountDetailListByAccountDetailListId(String accountDetailListId){
        return accountDetailListRepository.selectByPrimaryKey(accountDetailListId);
    }

}

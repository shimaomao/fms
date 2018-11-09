package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.AccountDetailListRepository;
import cn.com.leadu.fms.data.riskmgmt.repository.AccountDetailRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetail;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetail.AccountDetailVo;
import cn.com.leadu.fms.riskmgmt.service.AccountDetailService;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo.AccountDetailSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liujinge
 * @ClassName: AccountDetailService
 * @Description: 银行流水业务实现层
 * @date 2018-06-04
 */
@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    /**
     * @Fields  : 银行流水repository
     */
    @Autowired
    private AccountDetailRepository accountDetailRepository;

    /**
     * @Fields  : 银行流水明细repository
     */
    @Autowired
    private AccountDetailListRepository accountDetailListRepository;
    /**
     * @Title:
     * @Description: 分页查询银行流水
     * @param accountDetailVo
     * @return PageInfoExtend<AccountDetail>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    public PageInfoExtend<AccountDetail> findAccountDetailsByPage(AccountDetailVo accountDetailVo){
        Example example = SqlUtil.newExample(AccountDetail.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<AccountDetail> pageInfo = accountDetailRepository.selectListByExamplePage(example,accountDetailVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存银行流水
     * @param accountDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    public void saveAccountDetail(AccountDetailSaveVo accountDetailSaveVo){
        accountDetailRepository.insertData(accountDetailSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改银行流水
     * @param accountDetailModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    public void modifyAccountDetail(AccountDetailModifyVo accountDetailModifyVo){
        accountDetailRepository.updateByPrimaryKeySelectiveData(accountDetailModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过accountDetailId删除银行流水
     * @param accountDetailDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    public void deleteAccountDetail(AccountDetailDeleteVo accountDetailDeleteVo){
        accountDetailRepository.deleteData(accountDetailDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过accountDetailId集合删除银行流水
     * @param accountDetailDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    public void deleteAccountDetailsByAccountDetailIds(AccountDetailDeleteListVo accountDetailDeleteListVo){
        accountDetailRepository.deleteDataList(accountDetailDeleteListVo.getAccountDetailIds(),accountDetailDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据accountDetailId获取银行流水
     * @param accountDetailId
     * @return AccountDetail
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    public AccountDetail findAccountDetailByAccountDetailId(String accountDetailId){
        return accountDetailRepository.selectByPrimaryKey(accountDetailId);
    }
    /**
     * @Title:
     * @Description:  根据applyNo获取银行账户流水信息
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    @Override
    public List<AccountDetailVo> findAccountDetailVoListByApplyNo(String applyNo) {
        List<AccountDetailVo> accountDetailVoListRtn = new ArrayList();//用于返回的list
        Example example = SqlUtil.newExample(AccountDetail.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        example.setOrderByClause("relation asc");//根据关系类型排序
        List<AccountDetail> accountDetails = accountDetailRepository.selectListByExample(example);

        List<String> accountDetailIds = new ArrayList<>();//获取银行流水id
        if(accountDetails != null && accountDetails.size()>0){
            for(AccountDetail accountDetail : accountDetails){
                accountDetailIds.add(accountDetail.getAccountDetailId());
            }

            //查询银行流水明细
            Example example1 = SqlUtil.newExample(AccountDetailList.class);
            Example.Criteria criteria = example1.createCriteria();
            if(accountDetailIds.size()>0){
                criteria.andIn("accountDetailId",accountDetailIds);
            }
            example1.setOrderByClause("account_detail_id, year_mon asc");//根据年月升序排序
            List<AccountDetailList> accountDetailLists = accountDetailListRepository.selectListByExample(example1);
            //流水明细List转map
            Map<String, List<AccountDetailList>> accountDetailListMap = new HashMap<>();
            if(ArrayUtils.isNotNullAndLengthNotZero(accountDetailLists)){
                for(int i=0; i< accountDetailLists.size(); i++){
                    AccountDetailList accountDetailList = accountDetailLists.get(i);
                    if(accountDetailListMap.containsKey(accountDetailList.getAccountDetailId())){
                        accountDetailListMap.get(accountDetailList.getAccountDetailId()).add(accountDetailList);
                    }else{
                        List<AccountDetailList> accountDetailListsForMap = new ArrayList<>();
                        accountDetailListsForMap.add(accountDetailList);
                        accountDetailListMap.put(accountDetailList.getAccountDetailId(), accountDetailListsForMap);
                    }
                }
            }

            if(ArrayUtils.isNotNullAndLengthNotZero(accountDetails)){
                for(int i=0; i< accountDetails.size(); i++){
                    AccountDetailVo accountDetailVo = EntityUtils.getEntity(accountDetails.get(i), new AccountDetailVo());
                    accountDetailVo.setAccountDetailLists(accountDetailListMap.get(accountDetailVo.getAccountDetailId()));
                    accountDetailVoListRtn.add(accountDetailVo);
                }
            }
        }
        return accountDetailVoListRtn;
    }
}

package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.AccountDetailListDao;
import cn.com.leadu.fms.data.riskmgmt.repository.AccountDetailListRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailListRepositoryImpl
 * @Description: 银行流水明细Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class AccountDetailListRepositoryImpl extends AbstractBaseRepository<AccountDetailListDao, AccountDetailList> implements AccountDetailListRepository {

    /**
     * @Title:
     * @Description: 新增银行流水明细
     * @param accountDetailList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int insertData(AccountDetailList accountDetailList) {
        return super.insert(accountDetailList);
    }

    /**
     * @Title:
     * @Description: 批量保存银行流水明细
     * @param accountDetailLists
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int insertDataList(List<AccountDetailList> accountDetailLists){
        return super.insertListByJdbcTemplate(accountDetailLists);
    }

    /**
     * @Title:
     * @Description: 修改银行流水明细
     * @param accountDetailList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByPrimaryKeyData(AccountDetailList accountDetailList) {
        return super.updateByPrimaryKey(accountDetailList);
    }

    /**
     * @Title:
     * @Description: 批量修改银行流水明细
     * @param accountDetailLists
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AccountDetailList> accountDetailLists){
        return super.updateListByPrimaryKey(accountDetailLists);
    }

    /**
     * @Title:
     * @Description: 动态修改银行流水明细
     * @param accountDetailList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AccountDetailList accountDetailList) {
        return super.updateByPrimaryKeySelective(accountDetailList);
    }

    /**
     * @Title:
     * @Description: 批量动态修改银行流水明细
     * @param accountDetailLists
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AccountDetailList> accountDetailLists) {
        return super.updateListByPrimaryKeySelective(accountDetailLists);
    }

    /**
     * @Title:
     * @Description: 根据条件修改银行流水明细
     * @param accountDetailList
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByExampleData(AccountDetailList accountDetailList, Example example) {
        return super.updateByExample(accountDetailList,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改银行流水明细
     * @param accountDetailList
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByExampleSelectiveData(AccountDetailList accountDetailList, Example example){
        return super.updateByExampleSelective(accountDetailList,example);
    }
    
    /**
     * @Title:
     * @Description: 根据accountDetailListId删除银行流水明细
     * @param accountDetailList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int deleteData(AccountDetailList accountDetailList) {
        return super.delete(accountDetailList);
    }

    /**
     * @Title:
     * @Description: 根据accountDetailListId集合批量删除银行流水明细
     * @param accountDetailList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int deleteDataList(List accountDetailListIds,AccountDetailList accountDetailList){
        return super.deleteByIds(accountDetailListIds,accountDetailList);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除银行流水明细
     * @param example
     * @param accountDetailList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int deleteExampleData(Example example,AccountDetailList accountDetailList){
        return super.deleteByExample(example,accountDetailList);
    }

    /**
     * @Title:
     * @Description: 查询全部银行流水明细
     * @return List<AccountDetailList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public List<AccountDetailList> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个银行流水明细
     * @param example
     * @return AccountDetailList
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public AccountDetailList selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询银行流水明细
     * @param example
     * @return List<AccountDetailList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public List<AccountDetailList> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过accountDetailListId查询银行流水明细
     * @param accountDetailListId
     * @return AccountDetailList
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public AccountDetailList selectByPrimaryKey(Object accountDetailListId) {
        return super.selectByPrimaryKey(accountDetailListId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询银行流水明细
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<AccountDetailList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public PageInfoExtend<AccountDetailList> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询银行流水明细vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改银行流水明细
     * @param accountDetailList,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByPrimaryKeyData(AccountDetailList accountDetailList,boolean exclusive) {
        return super.updateByPrimaryKey(accountDetailList,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改银行流水明细,并进行排他
     * @param accountDetailLists
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AccountDetailList> accountDetailLists,boolean exclusive){
        return super.updateListByPrimaryKey(accountDetailLists,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改银行流水明细,并进行排他
     * @param accountDetailList
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AccountDetailList accountDetailList,boolean exclusive) {
        return super.updateByPrimaryKeySelective(accountDetailList,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改银行流水明细,并进行排他
     * @param accountDetailLists
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AccountDetailList> accountDetailLists,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(accountDetailLists,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改银行流水明细,并进行排他
     * @param accountDetailList
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByExampleData(AccountDetailList accountDetailList, Example example,boolean exclusive) {
        return super.updateByExample(accountDetailList,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改银行流水明细,并进行排他
     * @param accountDetailList
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:57
     */
    @Override
    public int updateByExampleSelectiveData(AccountDetailList accountDetailList, Example example,boolean exclusive){
        return super.updateByExampleSelective(accountDetailList,example,exclusive);
    }

}

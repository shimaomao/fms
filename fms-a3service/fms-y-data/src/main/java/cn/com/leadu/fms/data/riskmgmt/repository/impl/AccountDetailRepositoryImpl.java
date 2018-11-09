package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.AccountDetailDao;
import cn.com.leadu.fms.data.riskmgmt.repository.AccountDetailRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetail;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailRepositoryImpl
 * @Description: 银行流水Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class AccountDetailRepositoryImpl extends AbstractBaseRepository<AccountDetailDao, AccountDetail> implements AccountDetailRepository {

    /**
     * @Title:
     * @Description: 新增银行流水
     * @param accountDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int insertData(AccountDetail accountDetail) {
        return super.insert(accountDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存银行流水
     * @param accountDetails
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int insertDataList(List<AccountDetail> accountDetails){
        return super.insertListByJdbcTemplate(accountDetails);
    }

    /**
     * @Title:
     * @Description: 修改银行流水
     * @param accountDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByPrimaryKeyData(AccountDetail accountDetail) {
        return super.updateByPrimaryKey(accountDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改银行流水
     * @param accountDetails
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AccountDetail> accountDetails){
        return super.updateListByPrimaryKey(accountDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改银行流水
     * @param accountDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AccountDetail accountDetail) {
        return super.updateByPrimaryKeySelective(accountDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改银行流水
     * @param accountDetails
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AccountDetail> accountDetails) {
        return super.updateListByPrimaryKeySelective(accountDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改银行流水
     * @param accountDetail
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByExampleData(AccountDetail accountDetail, Example example) {
        return super.updateByExample(accountDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改银行流水
     * @param accountDetail
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByExampleSelectiveData(AccountDetail accountDetail, Example example){
        return super.updateByExampleSelective(accountDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据accountDetailId删除银行流水
     * @param accountDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int deleteData(AccountDetail accountDetail) {
        return super.delete(accountDetail);
    }

    /**
     * @Title:
     * @Description: 根据accountDetailId集合批量删除银行流水
     * @param accountDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int deleteDataList(List accountDetailIds,AccountDetail accountDetail){
        return super.deleteByIds(accountDetailIds,accountDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除银行流水
     * @param example
     * @param accountDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int deleteExampleData(Example example,AccountDetail accountDetail){
        return super.deleteByExample(example,accountDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部银行流水
     * @return List<AccountDetail>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public List<AccountDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个银行流水
     * @param example
     * @return AccountDetail
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public AccountDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询银行流水
     * @param example
     * @return List<AccountDetail>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public List<AccountDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过accountDetailId查询银行流水
     * @param accountDetailId
     * @return AccountDetail
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public AccountDetail selectByPrimaryKey(Object accountDetailId) {
        return super.selectByPrimaryKey(accountDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询银行流水
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<AccountDetail>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public PageInfoExtend<AccountDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询银行流水vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改银行流水
     * @param accountDetail,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByPrimaryKeyData(AccountDetail accountDetail,boolean exclusive) {
        return super.updateByPrimaryKey(accountDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改银行流水,并进行排他
     * @param accountDetails
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AccountDetail> accountDetails,boolean exclusive){
        return super.updateListByPrimaryKey(accountDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改银行流水,并进行排他
     * @param accountDetail
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AccountDetail accountDetail,boolean exclusive) {
        return super.updateByPrimaryKeySelective(accountDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改银行流水,并进行排他
     * @param accountDetails
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AccountDetail> accountDetails,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(accountDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改银行流水,并进行排他
     * @param accountDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByExampleData(AccountDetail accountDetail, Example example,boolean exclusive) {
        return super.updateByExample(accountDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改银行流水,并进行排他
     * @param accountDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:40
     */
    @Override
    public int updateByExampleSelectiveData(AccountDetail accountDetail, Example example,boolean exclusive){
        return super.updateByExampleSelective(accountDetail,example,exclusive);
    }

}

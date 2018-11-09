package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.SubjectAssisAccountDao;
import cn.com.leadu.fms.data.finance.repository.SubjectAssisAccountRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SubjectAssisAccountRepositoryImpl
 * @Description: 科目辅助核算管理Repository 实现层
 * @date 2018-06-23
 */
@Repository
public class SubjectAssisAccountRepositoryImpl extends AbstractBaseRepository<SubjectAssisAccountDao, SubjectAssisAccount> implements SubjectAssisAccountRepository {

    /**
     * @Title:
     * @Description: 新增科目辅助核算管理
     * @param subjectAssisAccount
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int insertData(SubjectAssisAccount subjectAssisAccount) {
        return super.insert(subjectAssisAccount);
    }

    /**
     * @Title:
     * @Description: 批量保存科目辅助核算管理
     * @param subjectAssisAccounts
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int insertDataList(List<SubjectAssisAccount> subjectAssisAccounts){
        return super.insertListByJdbcTemplate(subjectAssisAccounts);
    }

    /**
     * @Title:
     * @Description: 修改科目辅助核算管理
     * @param subjectAssisAccount
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByPrimaryKeyData(SubjectAssisAccount subjectAssisAccount) {
        return super.updateByPrimaryKey(subjectAssisAccount);
    }

    /**
     * @Title:
     * @Description: 批量修改科目辅助核算管理
     * @param subjectAssisAccounts
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SubjectAssisAccount> subjectAssisAccounts){
        return super.updateListByPrimaryKey(subjectAssisAccounts);
    }

    /**
     * @Title:
     * @Description: 动态修改科目辅助核算管理
     * @param subjectAssisAccount
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SubjectAssisAccount subjectAssisAccount) {
        return super.updateByPrimaryKeySelective(subjectAssisAccount);
    }

    /**
     * @Title:
     * @Description: 批量动态修改科目辅助核算管理
     * @param subjectAssisAccounts
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<SubjectAssisAccount> subjectAssisAccounts) {
        return super.updateListByPrimaryKeySelective(subjectAssisAccounts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改科目辅助核算管理
     * @param subjectAssisAccount
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByExampleData(SubjectAssisAccount subjectAssisAccount, Example example) {
        return super.updateByExample(subjectAssisAccount,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改科目辅助核算管理
     * @param subjectAssisAccount
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByExampleSelectiveData(SubjectAssisAccount subjectAssisAccount, Example example){
        return super.updateByExampleSelective(subjectAssisAccount,example);
    }
    
    /**
     * @Title:
     * @Description: 根据subjectAssisAccountId删除科目辅助核算管理
     * @param subjectAssisAccount
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int deleteData(SubjectAssisAccount subjectAssisAccount) {
        return super.delete(subjectAssisAccount);
    }

    /**
     * @Title:
     * @Description: 根据subjectAssisAccountId集合批量删除科目辅助核算管理
     * @param subjectAssisAccount
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int deleteDataList(List<String> subjectAssisAccountIds,SubjectAssisAccount subjectAssisAccount){
        return super.deleteByIds(subjectAssisAccountIds,subjectAssisAccount);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除科目辅助核算管理
     * @param example
     * @param subjectAssisAccount
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int deleteExampleData(Example example,SubjectAssisAccount subjectAssisAccount){
        return super.deleteByExample(example,subjectAssisAccount);
    }

    /**
     * @Title:
     * @Description: 查询全部科目辅助核算管理
     * @return List<SubjectAssisAccount>
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public List<SubjectAssisAccount> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个科目辅助核算管理
     * @param example
     * @return SubjectAssisAccount
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public SubjectAssisAccount selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询科目辅助核算管理
     * @param example
     * @return List<SubjectAssisAccount>
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public List<SubjectAssisAccount> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过subjectAssisAccountId查询科目辅助核算管理
     * @param subjectAssisAccountId
     * @return SubjectAssisAccount
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public SubjectAssisAccount selectByPrimaryKey(Object subjectAssisAccountId) {
        return super.selectByPrimaryKey(subjectAssisAccountId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询科目辅助核算管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SubjectAssisAccount>
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public PageInfoExtend<SubjectAssisAccount> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询科目辅助核算管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改科目辅助核算管理
     * @param subjectAssisAccount,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByPrimaryKeyData(SubjectAssisAccount subjectAssisAccount,boolean exclusive) {
        return super.updateByPrimaryKey(subjectAssisAccount,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改科目辅助核算管理,并进行排他
     * @param subjectAssisAccounts
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SubjectAssisAccount> subjectAssisAccounts,boolean exclusive){
        return super.updateListByPrimaryKey(subjectAssisAccounts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改科目辅助核算管理,并进行排他
     * @param subjectAssisAccount
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SubjectAssisAccount subjectAssisAccount,boolean exclusive) {
        return super.updateByPrimaryKeySelective(subjectAssisAccount,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改科目辅助核算管理,并进行排他
     * @param subjectAssisAccounts
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<SubjectAssisAccount> subjectAssisAccounts,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(subjectAssisAccounts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改科目辅助核算管理,并进行排他
     * @param subjectAssisAccount
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByExampleData(SubjectAssisAccount subjectAssisAccount, Example example,boolean exclusive) {
        return super.updateByExample(subjectAssisAccount,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改科目辅助核算管理,并进行排他
     * @param subjectAssisAccount
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 16:30:14
     */
    @Override
    public int updateByExampleSelectiveData(SubjectAssisAccount subjectAssisAccount, Example example,boolean exclusive){
        return super.updateByExampleSelective(subjectAssisAccount,example,exclusive);
    }

}

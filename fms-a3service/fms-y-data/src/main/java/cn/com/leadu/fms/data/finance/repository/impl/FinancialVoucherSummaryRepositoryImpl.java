package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinancialVoucherSummaryDao;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherSummaryRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryRepositoryImpl
 * @Description: 财务凭证管理Repository 实现层
 * @date 2018-07-21
 */
@Repository
public class FinancialVoucherSummaryRepositoryImpl extends AbstractBaseRepository<FinancialVoucherSummaryDao, FinancialVoucherSummary> implements FinancialVoucherSummaryRepository {

    /**
     * @Title:
     * @Description: 新增财务凭证管理
     * @param financialVoucherSummary
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int insertData(FinancialVoucherSummary financialVoucherSummary) {
        return super.insert(financialVoucherSummary);
    }

    /**
     * @Title:
     * @Description: 批量保存财务凭证管理
     * @param financialVoucherSummarys
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int insertDataList(List<FinancialVoucherSummary> financialVoucherSummarys){
        return super.insertListByJdbcTemplate(financialVoucherSummarys);
    }

    /**
     * @Title:
     * @Description: 修改财务凭证管理
     * @param financialVoucherSummary
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherSummary financialVoucherSummary) {
        return super.updateByPrimaryKey(financialVoucherSummary);
    }

    /**
     * @Title:
     * @Description: 批量修改财务凭证管理
     * @param financialVoucherSummarys
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherSummary> financialVoucherSummarys){
        return super.updateListByPrimaryKey(financialVoucherSummarys);
    }

    /**
     * @Title:
     * @Description: 动态修改财务凭证管理
     * @param financialVoucherSummary
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherSummary financialVoucherSummary) {
        return super.updateByPrimaryKeySelective(financialVoucherSummary);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务凭证管理
     * @param financialVoucherSummarys
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSummary> financialVoucherSummarys) {
        return super.updateListByPrimaryKeySelective(financialVoucherSummarys);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务凭证管理
     * @param financialVoucherSummary
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByExampleData(FinancialVoucherSummary financialVoucherSummary, Example example) {
        return super.updateByExample(financialVoucherSummary,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务凭证管理
     * @param financialVoucherSummary
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherSummary financialVoucherSummary, Example example){
        return super.updateByExampleSelective(financialVoucherSummary,example);
    }
    
    /**
     * @Title:
     * @Description: 根据voucherSummaryId删除财务凭证管理
     * @param financialVoucherSummary
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int deleteData(FinancialVoucherSummary financialVoucherSummary) {
        return super.delete(financialVoucherSummary);
    }

    /**
     * @Title:
     * @Description: 根据voucherSummaryId集合批量删除财务凭证管理
     * @param financialVoucherSummary
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int deleteDataList(List voucherSummaryIds,FinancialVoucherSummary financialVoucherSummary){
        return super.deleteByIds(voucherSummaryIds,financialVoucherSummary);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务凭证管理
     * @param example
     * @param financialVoucherSummary
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int deleteExampleData(Example example,FinancialVoucherSummary financialVoucherSummary){
        return super.deleteByExample(example,financialVoucherSummary);
    }

    /**
     * @Title:
     * @Description: 查询全部财务凭证管理
     * @return List<FinancialVoucherSummary>
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public List<FinancialVoucherSummary> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务凭证管理
     * @param example
     * @return FinancialVoucherSummary
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public FinancialVoucherSummary selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务凭证管理
     * @param example
     * @return List<FinancialVoucherSummary>
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public List<FinancialVoucherSummary> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过voucherSummaryId查询财务凭证管理
     * @param voucherSummaryId
     * @return FinancialVoucherSummary
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public FinancialVoucherSummary selectByPrimaryKey(Object voucherSummaryId) {
        return super.selectByPrimaryKey(voucherSummaryId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务凭证管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinancialVoucherSummary>
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public PageInfoExtend<FinancialVoucherSummary> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务凭证管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改财务凭证管理
     * @param financialVoucherSummary,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherSummary financialVoucherSummary,boolean exclusive) {
        return super.updateByPrimaryKey(financialVoucherSummary,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改财务凭证管理,并进行排他
     * @param financialVoucherSummarys
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherSummary> financialVoucherSummarys,boolean exclusive){
        return super.updateListByPrimaryKey(financialVoucherSummarys,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改财务凭证管理,并进行排他
     * @param financialVoucherSummary
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherSummary financialVoucherSummary,boolean exclusive) {
        return super.updateByPrimaryKeySelective(financialVoucherSummary,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务凭证管理,并进行排他
     * @param financialVoucherSummarys
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSummary> financialVoucherSummarys,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(financialVoucherSummarys,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务凭证管理,并进行排他
     * @param financialVoucherSummary
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByExampleData(FinancialVoucherSummary financialVoucherSummary, Example example,boolean exclusive) {
        return super.updateByExample(financialVoucherSummary,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务凭证管理,并进行排他
     * @param financialVoucherSummary
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:44:52
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherSummary financialVoucherSummary, Example example,boolean exclusive){
        return super.updateByExampleSelective(financialVoucherSummary,example,exclusive);
    }

}

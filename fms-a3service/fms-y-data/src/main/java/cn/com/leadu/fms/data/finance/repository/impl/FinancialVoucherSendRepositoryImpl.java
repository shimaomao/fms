package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinancialVoucherSendDao;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherSendRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSend;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendRepositoryImpl
 * @Description: 财务发送管理Repository 实现层
 * @date 2018-07-21
 */
@Repository
public class FinancialVoucherSendRepositoryImpl extends AbstractBaseRepository<FinancialVoucherSendDao, FinancialVoucherSend> implements FinancialVoucherSendRepository {

    /**
     * @Title:
     * @Description: 新增财务发送管理
     * @param financialVoucherSend
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int insertData(FinancialVoucherSend financialVoucherSend) {
        return super.insert(financialVoucherSend);
    }

    /**
     * @Title:
     * @Description: 批量保存财务发送管理
     * @param financialVoucherSends
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int insertDataList(List<FinancialVoucherSend> financialVoucherSends){
        return super.insertListByJdbcTemplate(financialVoucherSends);
    }

    /**
     * @Title:
     * @Description: 修改财务发送管理
     * @param financialVoucherSend
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherSend financialVoucherSend) {
        return super.updateByPrimaryKey(financialVoucherSend);
    }

    /**
     * @Title:
     * @Description: 批量修改财务发送管理
     * @param financialVoucherSends
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherSend> financialVoucherSends){
        return super.updateListByPrimaryKey(financialVoucherSends);
    }

    /**
     * @Title:
     * @Description: 动态修改财务发送管理
     * @param financialVoucherSend
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherSend financialVoucherSend) {
        return super.updateByPrimaryKeySelective(financialVoucherSend);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务发送管理
     * @param financialVoucherSends
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSend> financialVoucherSends) {
        return super.updateListByPrimaryKeySelective(financialVoucherSends);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务发送管理
     * @param financialVoucherSend
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByExampleData(FinancialVoucherSend financialVoucherSend, Example example) {
        return super.updateByExample(financialVoucherSend,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务发送管理
     * @param financialVoucherSend
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherSend financialVoucherSend, Example example){
        return super.updateByExampleSelective(financialVoucherSend,example);
    }
    
    /**
     * @Title:
     * @Description: 根据voucherSendId删除财务发送管理
     * @param financialVoucherSend
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int deleteData(FinancialVoucherSend financialVoucherSend) {
        return super.delete(financialVoucherSend);
    }

    /**
     * @Title:
     * @Description: 根据voucherSendId集合批量删除财务发送管理
     * @param financialVoucherSend
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int deleteDataList(List voucherSendIds,FinancialVoucherSend financialVoucherSend){
        return super.deleteByIds(voucherSendIds,financialVoucherSend);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务发送管理
     * @param example
     * @param financialVoucherSend
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int deleteExampleData(Example example,FinancialVoucherSend financialVoucherSend){
        return super.deleteByExample(example,financialVoucherSend);
    }

    /**
     * @Title:
     * @Description: 查询全部财务发送管理
     * @return List<FinancialVoucherSend>
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public List<FinancialVoucherSend> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务发送管理
     * @param example
     * @return FinancialVoucherSend
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public FinancialVoucherSend selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务发送管理
     * @param example
     * @return List<FinancialVoucherSend>
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public List<FinancialVoucherSend> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过voucherSendId查询财务发送管理
     * @param voucherSendId
     * @return FinancialVoucherSend
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public FinancialVoucherSend selectByPrimaryKey(Object voucherSendId) {
        return super.selectByPrimaryKey(voucherSendId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务发送管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinancialVoucherSend>
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public PageInfoExtend<FinancialVoucherSend> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务发送管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改财务发送管理
     * @param financialVoucherSend,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherSend financialVoucherSend,boolean exclusive) {
        return super.updateByPrimaryKey(financialVoucherSend,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改财务发送管理,并进行排他
     * @param financialVoucherSends
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherSend> financialVoucherSends,boolean exclusive){
        return super.updateListByPrimaryKey(financialVoucherSends,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改财务发送管理,并进行排他
     * @param financialVoucherSend
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherSend financialVoucherSend,boolean exclusive) {
        return super.updateByPrimaryKeySelective(financialVoucherSend,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务发送管理,并进行排他
     * @param financialVoucherSends
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherSend> financialVoucherSends,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(financialVoucherSends,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务发送管理,并进行排他
     * @param financialVoucherSend
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByExampleData(FinancialVoucherSend financialVoucherSend, Example example,boolean exclusive) {
        return super.updateByExample(financialVoucherSend,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务发送管理,并进行排他
     * @param financialVoucherSend
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-7-21 13:45:18
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherSend financialVoucherSend, Example example,boolean exclusive){
        return super.updateByExampleSelective(financialVoucherSend,example,exclusive);
    }

}

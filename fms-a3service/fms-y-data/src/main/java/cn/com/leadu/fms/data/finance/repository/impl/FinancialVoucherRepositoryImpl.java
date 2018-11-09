package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinancialVoucherDao;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherRepositoryImpl
 * @Description: 凭证类型管理Repository 实现层
 * @date 2018-06-20
 */
@Repository
public class FinancialVoucherRepositoryImpl extends AbstractBaseRepository<FinancialVoucherDao, FinancialVoucher> implements FinancialVoucherRepository {

    /**
     * @Title:
     * @Description: 新增凭证类型管理
     * @param financialVoucher
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int insertData(FinancialVoucher financialVoucher) {
        return super.insert(financialVoucher);
    }

    /**
     * @Title:
     * @Description: 批量保存凭证类型管理
     * @param financialVouchers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int insertDataList(List<FinancialVoucher> financialVouchers){
        return super.insertListByJdbcTemplate(financialVouchers);
    }

    /**
     * @Title:
     * @Description: 修改凭证类型管理
     * @param financialVoucher
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucher financialVoucher) {
        return super.updateByPrimaryKey(financialVoucher);
    }

    /**
     * @Title:
     * @Description: 批量修改凭证类型管理
     * @param financialVouchers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucher> financialVouchers){
        return super.updateListByPrimaryKey(financialVouchers);
    }

    /**
     * @Title:
     * @Description: 动态修改凭证类型管理
     * @param financialVoucher
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucher financialVoucher) {
        return super.updateByPrimaryKeySelective(financialVoucher);
    }

    /**
     * @Title:
     * @Description: 批量动态修改凭证类型管理
     * @param financialVouchers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucher> financialVouchers) {
        return super.updateListByPrimaryKeySelective(financialVouchers);
    }

    /**
     * @Title:
     * @Description: 根据条件修改凭证类型管理
     * @param financialVoucher
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByExampleData(FinancialVoucher financialVoucher, Example example) {
        return super.updateByExample(financialVoucher,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改凭证类型管理
     * @param financialVoucher
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucher financialVoucher, Example example){
        return super.updateByExampleSelective(financialVoucher,example);
    }
    
    /**
     * @Title:
     * @Description: 根据voucherId删除凭证类型管理
     * @param financialVoucher
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int deleteData(FinancialVoucher financialVoucher) {
        return super.delete(financialVoucher);
    }

    /**
     * @Title:
     * @Description: 根据voucherId集合批量删除凭证类型管理
     * @param financialVoucher
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int deleteDataList(List voucherIds,FinancialVoucher financialVoucher){
        return super.deleteByIds(voucherIds,financialVoucher);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除凭证类型管理
     * @param example
     * @param financialVoucher
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int deleteExampleData(Example example,FinancialVoucher financialVoucher){
        return super.deleteByExample(example,financialVoucher);
    }

    /**
     * @Title:
     * @Description: 查询全部凭证类型管理
     * @return List<FinancialVoucher>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public List<FinancialVoucher> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个凭证类型管理
     * @param example
     * @return FinancialVoucher
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public FinancialVoucher selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询凭证类型管理
     * @param example
     * @return List<FinancialVoucher>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public List<FinancialVoucher> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过voucherId查询凭证类型管理
     * @param voucherId
     * @return FinancialVoucher
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public FinancialVoucher selectByPrimaryKey(Object voucherId) {
        return super.selectByPrimaryKey(voucherId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询凭证类型管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinancialVoucher>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public PageInfoExtend<FinancialVoucher> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询凭证类型管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改凭证类型管理
     * @param financialVoucher,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucher financialVoucher,boolean exclusive) {
        return super.updateByPrimaryKey(financialVoucher,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改凭证类型管理,并进行排他
     * @param financialVouchers
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucher> financialVouchers,boolean exclusive){
        return super.updateListByPrimaryKey(financialVouchers,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改凭证类型管理,并进行排他
     * @param financialVoucher
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucher financialVoucher,boolean exclusive) {
        return super.updateByPrimaryKeySelective(financialVoucher,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改凭证类型管理,并进行排他
     * @param financialVouchers
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucher> financialVouchers,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(financialVouchers,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改凭证类型管理,并进行排他
     * @param financialVoucher
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByExampleData(FinancialVoucher financialVoucher, Example example,boolean exclusive) {
        return super.updateByExample(financialVoucher,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改凭证类型管理,并进行排他
     * @param financialVoucher
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucher financialVoucher, Example example,boolean exclusive){
        return super.updateByExampleSelective(financialVoucher,example,exclusive);
    }

}

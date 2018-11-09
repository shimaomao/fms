package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinancialVoucherDetailDao;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailRepositoryImpl
 * @Description: 凭证类型明细管理Repository 实现层
 * @date 2018-06-20
 */
@Repository
public class FinancialVoucherDetailRepositoryImpl extends AbstractBaseRepository<FinancialVoucherDetailDao, FinancialVoucherDetail> implements FinancialVoucherDetailRepository {

    /**
     * @Title:
     * @Description: 新增凭证类型明细管理
     * @param financialVoucherDetail
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int insertData(FinancialVoucherDetail financialVoucherDetail) {
        return super.insert(financialVoucherDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存凭证类型明细管理
     * @param financialVoucherDetails
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int insertDataList(List<FinancialVoucherDetail> financialVoucherDetails){
        return super.insertListByJdbcTemplate(financialVoucherDetails);
    }

    /**
     * @Title:
     * @Description: 修改凭证类型明细管理
     * @param financialVoucherDetail
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherDetail financialVoucherDetail) {
        return super.updateByPrimaryKey(financialVoucherDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改凭证类型明细管理
     * @param financialVoucherDetails
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherDetail> financialVoucherDetails){
        return super.updateListByPrimaryKey(financialVoucherDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改凭证类型明细管理
     * @param financialVoucherDetail
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherDetail financialVoucherDetail) {
        return super.updateByPrimaryKeySelective(financialVoucherDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改凭证类型明细管理
     * @param financialVoucherDetails
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherDetail> financialVoucherDetails) {
        return super.updateListByPrimaryKeySelective(financialVoucherDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改凭证类型明细管理
     * @param financialVoucherDetail
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByExampleData(FinancialVoucherDetail financialVoucherDetail, Example example) {
        return super.updateByExample(financialVoucherDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改凭证类型明细管理
     * @param financialVoucherDetail
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherDetail financialVoucherDetail, Example example){
        return super.updateByExampleSelective(financialVoucherDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据voucherDetailId删除凭证类型明细管理
     * @param financialVoucherDetail
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int deleteData(FinancialVoucherDetail financialVoucherDetail) {
        return super.delete(financialVoucherDetail);
    }

    /**
     * @Title:
     * @Description: 根据voucherDetailId集合批量删除凭证类型明细管理
     * @param financialVoucherDetail
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int deleteDataList(List voucherDetailIds,FinancialVoucherDetail financialVoucherDetail){
        return super.deleteByIds(voucherDetailIds,financialVoucherDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除凭证类型明细管理
     * @param example
     * @param financialVoucherDetail
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int deleteExampleData(Example example,FinancialVoucherDetail financialVoucherDetail){
        return super.deleteByExample(example,financialVoucherDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部凭证类型明细管理
     * @return List<FinancialVoucherDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public List<FinancialVoucherDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个凭证类型明细管理
     * @param example
     * @return FinancialVoucherDetail
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public FinancialVoucherDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询凭证类型明细管理
     * @param example
     * @return List<FinancialVoucherDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public List<FinancialVoucherDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过voucherDetailId查询凭证类型明细管理
     * @param voucherDetailId
     * @return FinancialVoucherDetail
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public FinancialVoucherDetail selectByPrimaryKey(Object voucherDetailId) {
        return super.selectByPrimaryKey(voucherDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询凭证类型明细管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinancialVoucherDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public PageInfoExtend<FinancialVoucherDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询凭证类型明细管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改凭证类型明细管理
     * @param financialVoucherDetail,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherDetail financialVoucherDetail,boolean exclusive) {
        return super.updateByPrimaryKey(financialVoucherDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改凭证类型明细管理,并进行排他
     * @param financialVoucherDetails
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherDetail> financialVoucherDetails,boolean exclusive){
        return super.updateListByPrimaryKey(financialVoucherDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改凭证类型明细管理,并进行排他
     * @param financialVoucherDetail
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherDetail financialVoucherDetail,boolean exclusive) {
        return super.updateByPrimaryKeySelective(financialVoucherDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改凭证类型明细管理,并进行排他
     * @param financialVoucherDetails
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherDetail> financialVoucherDetails,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(financialVoucherDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改凭证类型明细管理,并进行排他
     * @param financialVoucherDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByExampleData(FinancialVoucherDetail financialVoucherDetail, Example example,boolean exclusive) {
        return super.updateByExample(financialVoucherDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改凭证类型明细管理,并进行排他
     * @param financialVoucherDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherDetail financialVoucherDetail, Example example,boolean exclusive){
        return super.updateByExampleSelective(financialVoucherDetail,example,exclusive);
    }

}

package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.finance.dao.FinancialVoucherAssisDao;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherAssisRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherAssisRepositoryImpl
 * @Description: 财务凭证核算数据Repository 实现层
 * @date 2018-06-26
 */
@Repository
public class FinancialVoucherAssisRepositoryImpl extends AbstractBaseRepository<FinancialVoucherAssisDao, FinancialVoucherAssis> implements FinancialVoucherAssisRepository {

    /**
     * @Title:
     * @Description: 新增财务凭证核算数据
     * @param financialVoucherAssis
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int insertData(FinancialVoucherAssis financialVoucherAssis) {
        return super.insert(financialVoucherAssis);
    }

    /**
     * @Title:
     * @Description: 批量保存财务凭证核算数据
     * @param financialVoucherAssiss
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int insertDataList(List<FinancialVoucherAssis> financialVoucherAssiss){
        return super.insertListByJdbcTemplate(financialVoucherAssiss);
    }

    /**
     * @Title:
     * @Description: 修改财务凭证核算数据
     * @param financialVoucherAssis
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherAssis financialVoucherAssis) {
        return super.updateByPrimaryKey(financialVoucherAssis);
    }

    /**
     * @Title:
     * @Description: 批量修改财务凭证核算数据
     * @param financialVoucherAssiss
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherAssis> financialVoucherAssiss){
        return super.updateListByPrimaryKey(financialVoucherAssiss);
    }

    /**
     * @Title:
     * @Description: 动态修改财务凭证核算数据
     * @param financialVoucherAssis
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherAssis financialVoucherAssis) {
        return super.updateByPrimaryKeySelective(financialVoucherAssis);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务凭证核算数据
     * @param financialVoucherAssiss
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherAssis> financialVoucherAssiss) {
        return super.updateListByPrimaryKeySelective(financialVoucherAssiss);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务凭证核算数据
     * @param financialVoucherAssis
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByExampleData(FinancialVoucherAssis financialVoucherAssis, Example example) {
        return super.updateByExample(financialVoucherAssis,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务凭证核算数据
     * @param financialVoucherAssis
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherAssis financialVoucherAssis, Example example){
        return super.updateByExampleSelective(financialVoucherAssis,example);
    }
    
    /**
     * @Title:
     * @Description: 根据voucherAssisId删除财务凭证核算数据
     * @param financialVoucherAssis
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int deleteData(FinancialVoucherAssis financialVoucherAssis) {
        return super.delete(financialVoucherAssis);
    }

    /**
     * @Title:
     * @Description: 根据voucherAssisId集合批量删除财务凭证核算数据
     * @param financialVoucherAssis
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int deleteDataList(List voucherAssisIds,FinancialVoucherAssis financialVoucherAssis){
        return super.deleteByIds(voucherAssisIds,financialVoucherAssis);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务凭证核算数据
     * @param example
     * @param financialVoucherAssis
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int deleteExampleData(Example example,FinancialVoucherAssis financialVoucherAssis){
        return super.deleteByExample(example,financialVoucherAssis);
    }

    /**
     * @Title:
     * @Description: 查询全部财务凭证核算数据
     * @return List<FinancialVoucherAssis>
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public List<FinancialVoucherAssis> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务凭证核算数据
     * @param example
     * @return FinancialVoucherAssis
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public FinancialVoucherAssis selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务凭证核算数据
     * @param example
     * @return List<FinancialVoucherAssis>
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public List<FinancialVoucherAssis> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过voucherAssisId查询财务凭证核算数据
     * @param voucherAssisId
     * @return FinancialVoucherAssis
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public FinancialVoucherAssis selectByPrimaryKey(Object voucherAssisId) {
        return super.selectByPrimaryKey(voucherAssisId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务凭证核算数据
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinancialVoucherAssis>
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public PageInfoExtend<FinancialVoucherAssis> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务凭证核算数据vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改财务凭证核算数据
     * @param financialVoucherAssis,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherAssis financialVoucherAssis,boolean exclusive) {
        return super.updateByPrimaryKey(financialVoucherAssis,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改财务凭证核算数据,并进行排他
     * @param financialVoucherAssiss
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherAssis> financialVoucherAssiss,boolean exclusive){
        return super.updateListByPrimaryKey(financialVoucherAssiss,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改财务凭证核算数据,并进行排他
     * @param financialVoucherAssis
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherAssis financialVoucherAssis,boolean exclusive) {
        return super.updateByPrimaryKeySelective(financialVoucherAssis,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务凭证核算数据,并进行排他
     * @param financialVoucherAssiss
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherAssis> financialVoucherAssiss,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(financialVoucherAssiss,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务凭证核算数据,并进行排他
     * @param financialVoucherAssis
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByExampleData(FinancialVoucherAssis financialVoucherAssis, Example example,boolean exclusive) {
        return super.updateByExample(financialVoucherAssis,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务凭证核算数据,并进行排他
     * @param financialVoucherAssis
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-26 10:12:36
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherAssis financialVoucherAssis, Example example,boolean exclusive){
        return super.updateByExampleSelective(financialVoucherAssis,example,exclusive);
    }

    /**
     * @Title:
     * @Description:   根据财务凭证id获取核算数据
     * @param voucherDataId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/11 03:13:03
     */
    public List<FinancialVoucherAssisVo> selectFinancialVoucherAssisVosByVouDataId(String voucherDataId){
        return baseDao.selectFinancialVoucherAssisVosByVouDataId(voucherDataId);
    }

    /**
     * @Title:
     * @Description:   根据财务凭证id获取金蝶用户列表
     * @param finVouAssisVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 10:35:44
     */
    public List<KingDeeCusVo> selectKingDeeCusVosByVouDataIds(FinancialVoucherAssisVo finVouAssisVo){
        return baseDao.selectKingDeeCusVosByVouDataIds(finVouAssisVo);
    }

}

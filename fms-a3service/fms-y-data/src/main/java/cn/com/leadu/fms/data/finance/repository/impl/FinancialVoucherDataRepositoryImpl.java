package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.finance.dao.FinancialVoucherDataDao;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherDataRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata.FinancialVoucherDataVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataRepositoryImpl
 * @Description: 财务凭证数据Repository 实现层
 * @date 2018-06-21
 */
@Repository
public class FinancialVoucherDataRepositoryImpl extends AbstractBaseRepository<FinancialVoucherDataDao, FinancialVoucherData> implements FinancialVoucherDataRepository {

    /**
     * @Title:
     * @Description: 新增财务凭证数据
     * @param financialVoucherData
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int insertData(FinancialVoucherData financialVoucherData) {
        return super.insert(financialVoucherData);
    }

    /**
     * @Title:
     * @Description: 批量保存财务凭证数据
     * @param financialVoucherDatas
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int insertDataList(List<FinancialVoucherData> financialVoucherDatas){
        return super.insertListByJdbcTemplate(financialVoucherDatas);
    }

    /**
     * @Title:
     * @Description: 修改财务凭证数据
     * @param financialVoucherData
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherData financialVoucherData) {
        return super.updateByPrimaryKey(financialVoucherData);
    }

    /**
     * @Title:
     * @Description: 批量修改财务凭证数据
     * @param financialVoucherDatas
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherData> financialVoucherDatas){
        return super.updateListByPrimaryKey(financialVoucherDatas);
    }

    /**
     * @Title:
     * @Description: 动态修改财务凭证数据
     * @param financialVoucherData
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherData financialVoucherData) {
        return super.updateByPrimaryKeySelective(financialVoucherData);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务凭证数据
     * @param financialVoucherDatas
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherData> financialVoucherDatas) {
        return super.updateListByPrimaryKeySelective(financialVoucherDatas);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务凭证数据
     * @param financialVoucherData
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByExampleData(FinancialVoucherData financialVoucherData, Example example) {
        return super.updateByExample(financialVoucherData,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务凭证数据
     * @param financialVoucherData
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherData financialVoucherData, Example example){
        return super.updateByExampleSelective(financialVoucherData,example);
    }
    
    /**
     * @Title:
     * @Description: 根据voucherDataId删除财务凭证数据
     * @param financialVoucherData
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int deleteData(FinancialVoucherData financialVoucherData) {
        return super.delete(financialVoucherData);
    }

    /**
     * @Title:
     * @Description: 根据voucherDataId集合批量删除财务凭证数据
     * @param financialVoucherData
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int deleteDataList(List voucherDataIds,FinancialVoucherData financialVoucherData){
        return super.deleteByIds(voucherDataIds,financialVoucherData);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务凭证数据
     * @param example
     * @param financialVoucherData
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int deleteExampleData(Example example,FinancialVoucherData financialVoucherData){
        return super.deleteByExample(example,financialVoucherData);
    }

    /**
     * @Title:
     * @Description: 查询全部财务凭证数据
     * @return List<FinancialVoucherData>
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public List<FinancialVoucherData> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务凭证数据
     * @param example
     * @return FinancialVoucherData
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public FinancialVoucherData selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务凭证数据
     * @param example
     * @return List<FinancialVoucherData>
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public List<FinancialVoucherData> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过voucherDataId查询财务凭证数据
     * @param voucherDataId
     * @return FinancialVoucherData
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public FinancialVoucherData selectByPrimaryKey(Object voucherDataId) {
        return super.selectByPrimaryKey(voucherDataId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务凭证数据
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinancialVoucherData>
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public PageInfoExtend<FinancialVoucherData> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务凭证数据vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改财务凭证数据
     * @param financialVoucherData,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByPrimaryKeyData(FinancialVoucherData financialVoucherData,boolean exclusive) {
        return super.updateByPrimaryKey(financialVoucherData,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改财务凭证数据,并进行排他
     * @param financialVoucherDatas
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinancialVoucherData> financialVoucherDatas,boolean exclusive){
        return super.updateListByPrimaryKey(financialVoucherDatas,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改财务凭证数据,并进行排他
     * @param financialVoucherData
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinancialVoucherData financialVoucherData,boolean exclusive) {
        return super.updateByPrimaryKeySelective(financialVoucherData,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务凭证数据,并进行排他
     * @param financialVoucherDatas
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<FinancialVoucherData> financialVoucherDatas,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(financialVoucherDatas,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务凭证数据,并进行排他
     * @param financialVoucherData
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByExampleData(FinancialVoucherData financialVoucherData, Example example,boolean exclusive) {
        return super.updateByExample(financialVoucherData,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务凭证数据,并进行排他
     * @param financialVoucherData
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @Override
    public int updateByExampleSelectiveData(FinancialVoucherData financialVoucherData, Example example,boolean exclusive){
        return super.updateByExampleSelective(financialVoucherData,example,exclusive);
    }

    /**
     * @Title:
     * @Description:   查询财务凭证数据详情list
     * @param finVouDataVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/11 12:00:22
     */
    public List<FinancialVoucherDataVo> selectFinancialVoucherDataVos(FinancialVoucherDataVo finVouDataVo){
        return baseDao.selectFinancialVoucherDataVos(finVouDataVo);
    }

    /**
     * @Title:
     * @Description: 根据凭证号查询对应的凭证数据
     * @param:  voucherNo 凭证号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/16 0016 19:37
     */
    public List<FinancialVoucherDataVo> selectFinVouDataVoDetails(String voucherNo){
        return baseDao.selectFinVouDataVoDetails(voucherNo);
    }

}

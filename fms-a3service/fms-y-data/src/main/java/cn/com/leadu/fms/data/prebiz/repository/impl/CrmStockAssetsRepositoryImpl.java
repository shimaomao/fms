package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CrmStockAssetsDao;
import cn.com.leadu.fms.data.prebiz.repository.CrmStockAssetsRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmStockAssetsRepositoryImpl
 * @Description: crm股东信息Repository 实现层
 * @date 2018-08-27
 */
@Repository
public class CrmStockAssetsRepositoryImpl extends AbstractBaseRepository<CrmStockAssetsDao, CrmStockAssets> implements CrmStockAssetsRepository {

    /**
     * @Title:
     * @Description: 新增crm股东信息
     * @param crmStockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int insertData(CrmStockAssets crmStockAssets) {
        return super.insert(crmStockAssets);
    }

    /**
     * @Title:
     * @Description: 批量保存crm股东信息
     * @param crmStockAssetss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int insertDataList(List<CrmStockAssets> crmStockAssetss){
        return super.insertListByJdbcTemplate(crmStockAssetss);
    }

    /**
     * @Title:
     * @Description: 修改crm股东信息
     * @param crmStockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByPrimaryKeyData(CrmStockAssets crmStockAssets) {
        return super.updateByPrimaryKey(crmStockAssets);
    }

    /**
     * @Title:
     * @Description: 批量修改crm股东信息
     * @param crmStockAssetss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CrmStockAssets> crmStockAssetss){
        return super.updateListByPrimaryKey(crmStockAssetss);
    }

    /**
     * @Title:
     * @Description: 动态修改crm股东信息
     * @param crmStockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CrmStockAssets crmStockAssets) {
        return super.updateByPrimaryKeySelective(crmStockAssets);
    }

    /**
     * @Title:
     * @Description: 批量动态修改crm股东信息
     * @param crmStockAssetss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CrmStockAssets> crmStockAssetss) {
        return super.updateListByPrimaryKeySelective(crmStockAssetss);
    }

    /**
     * @Title:
     * @Description: 根据条件修改crm股东信息
     * @param crmStockAssets
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByExampleData(CrmStockAssets crmStockAssets, Example example) {
        return super.updateByExample(crmStockAssets,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改crm股东信息
     * @param crmStockAssets
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByExampleSelectiveData(CrmStockAssets crmStockAssets, Example example){
        return super.updateByExampleSelective(crmStockAssets,example);
    }
    
    /**
     * @Title:
     * @Description: 根据stockAssetsId删除crm股东信息
     * @param crmStockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int deleteData(CrmStockAssets crmStockAssets) {
        return super.delete(crmStockAssets);
    }

    /**
     * @Title:
     * @Description: 根据stockAssetsId集合批量删除crm股东信息
     * @param crmStockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int deleteDataList(List stockAssetsIds,CrmStockAssets crmStockAssets){
        return super.deleteByIds(stockAssetsIds,crmStockAssets);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除crm股东信息
     * @param example
     * @param crmStockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int deleteExampleData(Example example,CrmStockAssets crmStockAssets){
        return super.deleteByExample(example,crmStockAssets);
    }

    /**
     * @Title:
     * @Description: 查询全部crm股东信息
     * @return List<CrmStockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public List<CrmStockAssets> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个crm股东信息
     * @param example
     * @return CrmStockAssets
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public CrmStockAssets selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询crm股东信息
     * @param example
     * @return List<CrmStockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public List<CrmStockAssets> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过stockAssetsId查询crm股东信息
     * @param stockAssetsId
     * @return CrmStockAssets
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public CrmStockAssets selectByPrimaryKey(Object stockAssetsId) {
        return super.selectByPrimaryKey(stockAssetsId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询crm股东信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CrmStockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public PageInfoExtend<CrmStockAssets> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询crm股东信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改crm股东信息
     * @param crmStockAssets,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByPrimaryKeyData(CrmStockAssets crmStockAssets,boolean exclusive) {
        return super.updateByPrimaryKey(crmStockAssets,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改crm股东信息,并进行排他
     * @param crmStockAssetss
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CrmStockAssets> crmStockAssetss,boolean exclusive){
        return super.updateListByPrimaryKey(crmStockAssetss,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改crm股东信息,并进行排他
     * @param crmStockAssets
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CrmStockAssets crmStockAssets,boolean exclusive) {
        return super.updateByPrimaryKeySelective(crmStockAssets,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改crm股东信息,并进行排他
     * @param crmStockAssetss
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CrmStockAssets> crmStockAssetss,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(crmStockAssetss,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改crm股东信息,并进行排他
     * @param crmStockAssets
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByExampleData(CrmStockAssets crmStockAssets, Example example,boolean exclusive) {
        return super.updateByExample(crmStockAssets,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改crm股东信息,并进行排他
     * @param crmStockAssets
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    @Override
    public int updateByExampleSelectiveData(CrmStockAssets crmStockAssets, Example example,boolean exclusive){
        return super.updateByExampleSelective(crmStockAssets,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根據id集合物理刪除數據
     * @param ids
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public int deletePhysicsEntityList(List ids){
        return super.deletePhysicsEntityList(ids);
    }
}

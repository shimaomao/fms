package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.StockAssetsDao;
import cn.com.leadu.fms.data.prebiz.repository.StockAssetsRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.StockAssets;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: StockAssetsRepositoryImpl
 * @Description: 股份资产Repository 实现层
 * @date 2018-05-28
 */
@Repository
public class StockAssetsRepositoryImpl extends AbstractBaseRepository<StockAssetsDao, StockAssets> implements StockAssetsRepository {

    /**
     * @Title:
     * @Description: 新增股份资产
     * @param stockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int insertData(StockAssets stockAssets) {
        return super.insert(stockAssets);
    }

    /**
     * @Title:
     * @Description: 批量保存股份资产
     * @param stockAssetss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int insertDataList(List<StockAssets> stockAssetss){
        return super.insertListByJdbcTemplate(stockAssetss);
    }

    /**
     * @Title:
     * @Description: 修改股份资产
     * @param stockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int updateByPrimaryKeyData(StockAssets stockAssets) {
        return super.updateByPrimaryKey(stockAssets);
    }

    /**
     * @Title:
     * @Description: 批量修改股份资产
     * @param stockAssetss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int updateByPrimaryKeyDataList(List<StockAssets> stockAssetss){
        return super.updateListByPrimaryKey(stockAssetss);
    }

    /**
     * @Title:
     * @Description: 动态修改股份资产
     * @param stockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int updateByPrimaryKeySelectiveData(StockAssets stockAssets) {
        return super.updateByPrimaryKeySelective(stockAssets);
    }

    /**
     * @Title:
     * @Description: 批量动态修改股份资产
     * @param stockAssetss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    public int updateByPrimaryKeySelectiveDataList(List<StockAssets> stockAssetss) {
        return super.updateListByPrimaryKeySelective(stockAssetss);
    }

    /**
     * @Title:
     * @Description: 根据条件修改股份资产
     * @param stockAssets
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int updateByExampleData(StockAssets stockAssets, Example example) {
        return super.updateByExample(stockAssets,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改股份资产
     * @param stockAssets
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int updateByExampleSelectiveData(StockAssets stockAssets, Example example){
        return super.updateByExampleSelective(stockAssets,example);
    }
    
    /**
     * @Title:
     * @Description: 根据stockAssetsId删除股份资产
     * @param stockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public int deleteData(StockAssets stockAssets) {
        return super.delete(stockAssets);
    }

    /**
     * @Title:
     * @Description: 根据stockAssetsId集合批量删除股份资产
     * @param stockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    public int deleteDataList(List stockAssetsIds,StockAssets stockAssets){
        return super.deleteByIds(stockAssetsIds,stockAssets);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除股份资产
     * @param example
     * @param stockAssets
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    public int deleteExampleData(Example example,StockAssets stockAssets){
        return super.deleteByExample(example,stockAssets);
    }

    /**
     * @Title:
     * @Description: 查询全部股份资产
     * @return List<StockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public List<StockAssets> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个股份资产
     * @param example
     * @return StockAssets
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public StockAssets selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询股份资产
     * @param example
     * @return List<StockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public List<StockAssets> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过stockAssetsId查询股份资产
     * @param stockAssetsId
     * @return StockAssets
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public StockAssets selectByPrimaryKey(Object stockAssetsId) {
        return super.selectByPrimaryKey(stockAssetsId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询股份资产
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<StockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    @Override
    public PageInfoExtend<StockAssets> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询股份资产vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:31
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

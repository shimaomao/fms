package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.data.product.dao.ProdFinItemDao;
import cn.com.leadu.fms.data.product.repository.ProdFinItemRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdFinItem;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFinItemRepositoryImpl
 * @Description: 产品方案融资项目Repository 实现层
 * @date 2018-04-06
 */
@Repository
public class ProdFinItemRepositoryImpl extends AbstractBaseRepository<ProdFinItemDao, ProdFinItem> implements ProdFinItemRepository {

    /**
     * @Title:
     * @Description: 新增产品方案融资项目
     * @param prodFinItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int insertData(ProdFinItem prodFinItem) {
        return super.insert(prodFinItem);
    }

    /**
     * @Title:
     * @Description: 批量保存产品方案融资项目
     * @param prodFinItems
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int insertDataList(List<ProdFinItem> prodFinItems){
        return super.insertListByJdbcTemplate(prodFinItems);
    }

    /**
     * @Title:
     * @Description: 修改产品方案融资项目
     * @param prodFinItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int updateByPrimaryKeyData(ProdFinItem prodFinItem) {
        return super.updateByPrimaryKey(prodFinItem);
    }

    /**
     * @Title:
     * @Description: 批量修改产品方案融资项目
     * @param prodFinItems
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ProdFinItem> prodFinItems){
        return super.updateListByPrimaryKey(prodFinItems);
    }

    /**
     * @Title:
     * @Description: 动态修改产品方案融资项目
     * @param prodFinItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ProdFinItem prodFinItem) {
        return super.updateByPrimaryKeySelective(prodFinItem);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品方案融资项目
     * @param prodFinItems
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    public int updateByPrimaryKeySelectiveDataList(List<ProdFinItem> prodFinItems) {
        return super.updateListByPrimaryKeySelective(prodFinItems);
    }

    /**
     * @Title:
     * @Description: 根据条件修改产品方案融资项目
     * @param prodFinItem
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int updateByExampleData(ProdFinItem prodFinItem, Example example) {
        return super.updateByExample(prodFinItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改产品方案融资项目
     * @param prodFinItem
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int updateByExampleSelectiveData(ProdFinItem prodFinItem, Example example){
        return super.updateByExampleSelective(prodFinItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据prodFinItemId删除产品方案融资项目
     * @param prodFinItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public int deleteData(ProdFinItem prodFinItem) {
        return super.delete(prodFinItem);
    }

    /**
     * @Title:
     * @Description: 根据prodFinItemId集合批量删除产品方案融资项目
     * @param prodFinItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    public int deleteDataList(List prodFinItemIds,ProdFinItem prodFinItem){
        return super.deleteByIds(prodFinItemIds,prodFinItem);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除产品方案融资项目
     * @param example
     * @param prodFinItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    public int deleteExampleData(Example example,ProdFinItem prodFinItem){
        return super.deleteByExample(example,prodFinItem);
    }

    /**
     * @Title:
     * @Description: 查询全部产品方案融资项目
     * @return List<ProdFinItem>
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public List<ProdFinItem> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品方案融资项目
     * @param example
     * @return ProdFinItem
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public ProdFinItem selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品方案融资项目
     * @param example
     * @return List<ProdFinItem>
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public List<ProdFinItem> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过prodFinItemId查询产品方案融资项目
     * @param prodFinItemId
     * @return ProdFinItem
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public ProdFinItem selectByPrimaryKey(Object prodFinItemId) {
        return super.selectByPrimaryKey(prodFinItemId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询产品方案融资项目
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ProdFinItem>
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public PageInfoExtend<ProdFinItem> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询产品方案融资项目vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ProdFinItem>
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    public PageInfoExtend<ProdFinItem> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

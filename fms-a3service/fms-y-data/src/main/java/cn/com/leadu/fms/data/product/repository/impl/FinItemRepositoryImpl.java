package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.data.product.dao.FinItemDao;
import cn.com.leadu.fms.data.product.repository.FinItemRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.product.entity.FinItem;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: FinItemRepositoryImpl
 * @Description: 融资项目管理Repository 实现层
 * @date 2018-03-19
 */
@Repository
public class FinItemRepositoryImpl extends AbstractBaseRepository<FinItemDao, FinItem> implements FinItemRepository {

    /**
     * @Title:
     * @Description: 新增融资项目管理
     * @param finItem
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int insertData(FinItem finItem) {
        return super.insert(finItem);
    }

    /**
     * @Title:
     * @Description: 批量保存融资项目管理
     * @param finItems
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int insertDataList(List<FinItem> finItems){
        return super.insertListByJdbcTemplate(finItems);
    }

    /**
     * @Title:
     * @Description: 修改融资项目管理
     * @param finItem
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int updateByPrimaryKeyData(FinItem finItem) {
        return super.updateByPrimaryKey(finItem);
    }

    /**
     * @Title:
     * @Description: 批量修改融资项目管理
     * @param finItems
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinItem> finItems){
        return super.updateListByPrimaryKey(finItems);
    }

    /**
     * @Title:
     * @Description: 动态修改融资项目管理
     * @param finItem
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinItem finItem) {
        return super.updateByPrimaryKeySelective(finItem);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资项目管理
     * @param finItems
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public int updateByPrimaryKeySelectiveDataList(List<FinItem> finItems) {
        return super.updateListByPrimaryKeySelective(finItems);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资项目管理
     * @param finItem
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int updateByExampleData(FinItem finItem, Example example) {
        return super.updateByExample(finItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资项目管理
     * @param finItem
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int updateByExampleSelectiveData(FinItem finItem, Example example){
        return super.updateByExampleSelective(finItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据finItemId删除融资项目管理
     * @param finItem
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public int deleteData(FinItem finItem) {
        return super.delete(finItem);
    }

    /**
     * @Title:
     * @Description: 根据finItemId集合批量删除融资项目管理
     * @param finItem
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public int deleteDataList(List finItemIds,FinItem finItem){
        return super.deleteByIds(finItemIds,finItem);
    }

    /**
     * @Title:
     * @Description: 查询全部融资项目管理
     * @return List<FinItem>
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public List<FinItem> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资项目管理
     * @param example
     * @return FinItem
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public FinItem selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资项目管理
     * @param example
     * @return List<FinItem>
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public List<FinItem> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过finItemId查询融资项目管理
     * @param finItemId
     * @return FinItem
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public FinItem selectByPrimaryKey(Object finItemId) {
        return super.selectByPrimaryKey(finItemId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资项目管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinItem>
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @Override
    public PageInfoExtend<FinItem> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资项目管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<FinItem>
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public PageInfoExtend<FinItem> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据产品方案代码，获取产品方案的融资项目
     * @param product 产品方案代码
     * @throws
     * @author wangxue
     * @date 2018-3-24 22:06:58
     */
    @Override
    public List<FinItemVo> selectFinItemVoListByProduct(String product) {
        return baseDao.selectFinItemVoListByProduct(product);
    }
}

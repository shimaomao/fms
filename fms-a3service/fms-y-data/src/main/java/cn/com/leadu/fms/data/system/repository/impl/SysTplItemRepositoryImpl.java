package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysTplItemDao;
import cn.com.leadu.fms.data.system.repository.SysTplItemRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysTplItem;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemRepositoryImpl
 * @Description: 模板可设项目管理Repository 实现层
 * @date 2018-03-12
 */
@Repository
public class SysTplItemRepositoryImpl extends AbstractBaseRepository<SysTplItemDao, SysTplItem> implements SysTplItemRepository {

    /**
     * @Title:
     * @Description: 新增模板可设项目管理
     * @param sysTplItem
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int insertData(SysTplItem sysTplItem) {
        return super.insert(sysTplItem);
    }

    /**
     * @Title:
     * @Description: 批量保存模板可设项目管理
     * @param sysTplItems
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int insertDataList(List<SysTplItem> sysTplItems){
        return super.insertListByJdbcTemplate(sysTplItems);
    }

    /**
     * @Title:
     * @Description: 修改模板可设项目管理
     * @param sysTplItem
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int updateByPrimaryKeyData(SysTplItem sysTplItem) {
        return super.updateByPrimaryKey(sysTplItem);
    }

    /**
     * @Title:
     * @Description: 批量修改模板可设项目管理
     * @param sysTplItems
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysTplItem> sysTplItems){
        return super.updateListByPrimaryKey(sysTplItems);
    }

    /**
     * @Title:
     * @Description: 动态修改模板可设项目管理
     * @param sysTplItem
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysTplItem sysTplItem) {
        return super.updateByPrimaryKeySelective(sysTplItem);
    }

    /**
     * @Title:
     * @Description: 批量动态修改模板可设项目管理
     * @param sysTplItems
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysTplItem> sysTplItems) {
        return super.updateListByPrimaryKeySelective(sysTplItems);
    }

    /**
     * @Title:
     * @Description: 根据条件修改模板可设项目管理
     * @param sysTplItem
     * @param example
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int updateByExampleData(SysTplItem sysTplItem, Example example) {
        return super.updateByExample(sysTplItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改模板可设项目管理
     * @param sysTplItem
     * @param example
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int updateByExampleSelectiveData(SysTplItem sysTplItem, Example example){
        return super.updateByExampleSelective(sysTplItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据tplItemId删除模板可设项目管理
     * @param sysTplItem
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public int deleteData(SysTplItem sysTplItem) {
        return super.delete(sysTplItem);
    }

    /**
     * @Title:
     * @Description: 根据tplItemId集合批量删除模板可设项目管理
     * @param sysTplItem
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    public int deleteDataList(List tplItemIds,SysTplItem sysTplItem){
        return super.deleteByIds(tplItemIds,sysTplItem);
    }

    /**
     * @Title:
     * @Description: 查询全部模板可设项目管理
     * @return List<SysTplItem>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public List<SysTplItem> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个模板可设项目管理
     * @param example
     * @return SysTplItem
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public SysTplItem selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询模板可设项目管理
     * @param example
     * @return List<SysTplItem>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public List<SysTplItem> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过tplItemId查询模板可设项目管理
     * @param tplItemId
     * @return SysTplItem
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public SysTplItem selectByPrimaryKey(Object tplItemId) {
        return super.selectByPrimaryKey(tplItemId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询模板可设项目管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysTplItem>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @Override
    public PageInfoExtend<SysTplItem> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询模板可设项目管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysTplItem>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    public PageInfoExtend<SysTplItem> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

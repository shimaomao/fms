package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysTplTypeDao;
import cn.com.leadu.fms.data.system.repository.SysTplTypeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeRepositoryImpl
 * @Description: 模板类型管理Repository 实现层
 * @date 2018-03-12
 */
@Repository
public class SysTplTypeRepositoryImpl extends AbstractBaseRepository<SysTplTypeDao, SysTplType> implements SysTplTypeRepository {

    /**
     * @Title:
     * @Description: 新增模板类型管理
     * @param sysTplType
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int insertData(SysTplType sysTplType) {
        return super.insert(sysTplType);
    }

    /**
     * @Title:
     * @Description: 批量保存模板类型管理
     * @param sysTplTypes
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int insertDataList(List<SysTplType> sysTplTypes){
        return super.insertListByJdbcTemplate(sysTplTypes);
    }

    /**
     * @Title:
     * @Description: 修改模板类型管理
     * @param sysTplType
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int updateByPrimaryKeyData(SysTplType sysTplType) {
        return super.updateByPrimaryKey(sysTplType);
    }

    /**
     * @Title:
     * @Description: 批量修改模板类型管理
     * @param sysTplTypes
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysTplType> sysTplTypes){
        return super.insertListByJdbcTemplate(sysTplTypes);
    }

    /**
     * @Title:
     * @Description: 动态修改模板类型管理
     * @param sysTplType
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysTplType sysTplType) {
        return super.updateByPrimaryKeySelective(sysTplType);
    }

    /**
     * @Title:
     * @Description: 批量动态修改模板类型管理
     * @param sysTplTypes
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysTplType> sysTplTypes) {
        return super.updateListByPrimaryKeySelective(sysTplTypes);
    }

    /**
     * @Title:
     * @Description: 根据条件修改模板类型管理
     * @param sysTplType
     * @param example
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int updateByExampleData(SysTplType sysTplType, Example example) {
        return super.updateByExample(sysTplType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改模板类型管理
     * @param sysTplType
     * @param example
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int updateByExampleSelectiveData(SysTplType sysTplType, Example example){
        return super.updateByExampleSelective(sysTplType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据tplTypeId删除模板类型管理
     * @param sysTplType
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public int deleteData(SysTplType sysTplType) {
        return super.delete(sysTplType);
    }

    /**
     * @Title:
     * @Description: 根据tplTypeId集合批量删除模板类型管理
     * @param sysTplType
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    public int deleteDataList(List tplTypeIds,SysTplType sysTplType){
        return super.deleteByIds(tplTypeIds,sysTplType);
    }

    /**
     * @Title:
     * @Description: 查询全部模板类型管理
     * @return List<SysTplType>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public List<SysTplType> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个模板类型管理
     * @param example
     * @return SysTplType
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public SysTplType selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询模板类型管理
     * @param example
     * @return List<SysTplType>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public List<SysTplType> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过tplTypeId查询模板类型管理
     * @param tplTypeId
     * @return SysTplType
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public SysTplType selectByPrimaryKey(Object tplTypeId) {
        return super.selectByPrimaryKey(tplTypeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询模板类型管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysTplType>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Override
    public PageInfoExtend<SysTplType> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询模板类型管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysTplType>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    public PageInfoExtend<SysTplType> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据模板类型ID集合,获取使用这些模板类型的模板的件数
     * @param tplTypeIds 用户组Id
     * @return Long
     * @throws
     * @author wangxue
     * @date 2018-3-15 12:39:58
     */
    @Override
    public Long selectSysTplCountByTplTypeIds(List<String> tplTypeIds) {
        return baseDao.selectSysTplCountByTplTypeIds(tplTypeIds);
    }

    /**
     * @Title:
     * @Description: 根据模板类型ID集合,获取模板类型的可设置项目集合
     * @param tplTypeIds 用户组Id
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-3-15 12:39:58
     */
    @Override
    public List<String> selectSysTplItemIdsByTplTypeIds(List<String> tplTypeIds) {
        return baseDao.selectSysTplItemIdsByTplTypeIds(tplTypeIds);
    }
}

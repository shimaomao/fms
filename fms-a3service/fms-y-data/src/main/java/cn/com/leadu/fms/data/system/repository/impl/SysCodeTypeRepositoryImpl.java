package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysCodeTypeDao;
import cn.com.leadu.fms.data.system.repository.SysCodeTypeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeRepositoryImpl
 * @Description: 字典数据类型Repository 实现层
 * @date 2018-03-08
 */
@Repository
public class SysCodeTypeRepositoryImpl extends AbstractBaseRepository<SysCodeTypeDao, SysCodeType> implements SysCodeTypeRepository {

    /**
     * @Title:
     * @Description: 新增字典数据类型
     * @param sysCodeType
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int insertData(SysCodeType sysCodeType) {
        return super.insert(sysCodeType);
    }

    /**
     * @Title:
     * @Description: 批量保存字典数据类型
     * @param sysCodeTypes
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int insertDataList(List<SysCodeType> sysCodeTypes){
        return super.insertListByJdbcTemplate(sysCodeTypes);
    }

    /**
     * @Title:
     * @Description: 修改字典数据类型
     * @param sysCodeType
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int updateByPrimaryKeyData(SysCodeType sysCodeType) {
        return super.updateByPrimaryKey(sysCodeType);
    }

    /**
     * @Title:
     * @Description: 批量修改字典数据类型
     * @param sysCodeTypes
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysCodeType> sysCodeTypes){
        return super.updateListByPrimaryKey(sysCodeTypes);
    }

    /**
     * @Title:
     * @Description: 动态修改字典数据类型
     * @param sysCodeType
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysCodeType sysCodeType) {
        return super.updateByPrimaryKeySelective(sysCodeType);
    }

    /**
     * @Title:
     * @Description: 批量动态修改字典数据类型
     * @param sysCodeTypes
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysCodeType> sysCodeTypes) {
        return super.updateListByPrimaryKeySelective(sysCodeTypes);
    }

    /**
     * @Title:
     * @Description: 根据条件修改字典数据类型
     * @param sysCodeType
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int updateByExampleData(SysCodeType sysCodeType, Example example) {
        return super.updateByExample(sysCodeType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改字典数据类型
     * @param sysCodeType
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int updateByExampleSelectiveData(SysCodeType sysCodeType, Example example){
        return super.updateByExampleSelective(sysCodeType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ID删除字典数据类型
     * @param sysCodeType
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public int deleteData(SysCodeType sysCodeType) {
        return super.delete(sysCodeType);
    }

    /**
     * @Title:
     * @Description: 根据ID集合批量删除字典数据类型
     * @param sysCodeType
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public int deleteDataList(List ids,SysCodeType sysCodeType){
        return super.deleteByIds(ids,sysCodeType);
    }

    /**
     *  根据条件删除
     * @param example
     * @param sysCodeType
     * @return
     */
    public int deleteExampleData(Example example,SysCodeType sysCodeType){
        return super.deleteByExample(example,sysCodeType);
    }

    /**
     * @Title:
     * @Description: 根据ID集合批量删除字典数据类型
     * @param sysCodeType
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public int deleteByIds(List ids,SysCodeType sysCodeType,String primaryKey){
        return super.deleteByIds(ids,sysCodeType,primaryKey);
    }

    /**
     * @Title:
     * @Description: 查询全部字典数据类型
     * @return List<SysCodeType>
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public List<SysCodeType> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个字典数据类型
     * @param example
     * @return SysCodeType
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public SysCodeType selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询字典数据类型
     * @param example
     * @return List<SysCodeType>
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public List<SysCodeType> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ID查询字典数据类型
     * @param id
     * @return SysCodeType
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public SysCodeType selectByPrimaryKey(Object id) {
        return super.selectByPrimaryKey(id);
    }
    
    /**
     * @Title:
     * @Description: 分页查询字典数据类型
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysCodeType>
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Override
    public PageInfoExtend<SysCodeType> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询字典数据类型vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysCodeType>
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public PageInfoExtend<SysCodeType> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

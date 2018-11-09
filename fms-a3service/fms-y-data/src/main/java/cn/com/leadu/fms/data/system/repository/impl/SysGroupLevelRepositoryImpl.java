package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysGroupLevelDao;
import cn.com.leadu.fms.data.system.repository.SysGroupLevelRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysGroupLevel;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelRepositoryImpl
 * @Description: 用户组层级Repository 实现层
 * @date 2018-03-08
 */
@Repository
public class SysGroupLevelRepositoryImpl extends AbstractBaseRepository<SysGroupLevelDao, SysGroupLevel> implements SysGroupLevelRepository {

    /**
     * @Title:
     * @Description: 新增用户组层级
     * @param sysGroupLevel
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int insertData(SysGroupLevel sysGroupLevel) {
        return super.insert(sysGroupLevel);
    }

    /**
     * @Title:
     * @Description: 批量保存用户组层级
     * @param sysGroupLevels
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int insertDataList(List<SysGroupLevel> sysGroupLevels){
        return super.insertListByJdbcTemplate(sysGroupLevels);
    }

    /**
     * @Title:
     * @Description: 修改用户组层级
     * @param sysGroupLevel
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int updateByPrimaryKeyData(SysGroupLevel sysGroupLevel) {
        return super.updateByPrimaryKey(sysGroupLevel);
    }

    /**
     * @Title:
     * @Description: 批量修改用户组层级
     * @param sysGroupLevels
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysGroupLevel> sysGroupLevels){
        return super.insertListByJdbcTemplate(sysGroupLevels);
    }

    /**
     * @Title:
     * @Description: 动态修改用户组层级
     * @param sysGroupLevel
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysGroupLevel sysGroupLevel) {
        return super.updateByPrimaryKeySelective(sysGroupLevel);
    }

    /**
     * @Title:
     * @Description: 批量动态修改用户组层级
     * @param sysGroupLevels
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysGroupLevel> sysGroupLevels) {
        return super.updateListByPrimaryKeySelective(sysGroupLevels);
    }

    /**
     * @Title:
     * @Description: 根据条件修改用户组层级
     * @param sysGroupLevel
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int updateByExampleData(SysGroupLevel sysGroupLevel, Example example) {
        return super.updateByExample(sysGroupLevel,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改用户组层级
     * @param sysGroupLevel
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int updateByExampleSelectiveData(SysGroupLevel sysGroupLevel, Example example){
        return super.updateByExampleSelective(sysGroupLevel,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ID删除用户组层级
     * @param sysGroupLevel
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public int deleteData(SysGroupLevel sysGroupLevel) {
        return super.delete(sysGroupLevel);
    }

    /**
     * @Title:
     * @Description: 根据ID集合批量删除用户组层级
     * @param sysGroupLevel
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public int deleteDataList(List ids,SysGroupLevel sysGroupLevel){
        return super.deleteByIds(ids,sysGroupLevel);
    }

    /**
     * @Title:
     * @Description: 查询全部用户组层级
     * @return List<SysGroupLevel>
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public List<SysGroupLevel> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个用户组层级
     * @param example
     * @return SysGroupLevel
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public SysGroupLevel selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询用户组层级
     * @param example
     * @return List<SysGroupLevel>
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public List<SysGroupLevel> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ID查询用户组层级
     * @param id
     * @return SysGroupLevel
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public SysGroupLevel selectByPrimaryKey(Object id) {
        return super.selectByPrimaryKey(id);
    }
    
    /**
     * @Title:
     * @Description: 分页查询用户组层级
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysGroupLevel>
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @Override
    public PageInfoExtend<SysGroupLevel> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询用户组层级vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysGroupLevel>
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public PageInfoExtend<SysGroupLevel> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

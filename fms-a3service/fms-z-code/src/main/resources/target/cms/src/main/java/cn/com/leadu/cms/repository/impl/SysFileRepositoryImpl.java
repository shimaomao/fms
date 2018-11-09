package cn.com.leadu.fms.data.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysFileDao;
import cn.com.leadu.fms.data.system.repository.SysFileRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysFile;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysFileRepositoryImpl
 * @Description: 菜单Repository 实现层
 * @date 2018-03-05
 */
@Repository
public class SysFileRepositoryImpl extends AbstractBaseRepository<SysFileDao, SysFile> implements SysFileRepository {

    /**
     * @Title:
     * @Description: 新增菜单
     * @param sysFile
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int insertData(SysFile sysFile) {
        return super.insert(sysFile);
    }

    /**
     * @Title:
     * @Description: 批量保存菜单
     * @param sysFiles
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int insertDataList(List<SysFile> sysFiles){
        return super.insertListByJdbcTemplate(sysFiles);
    }

    /**
     * @Title:
     * @Description: 修改菜单
     * @param sysFile
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int updateByPrimaryKeyData(SysFile sysFile) {
        return super.updateByPrimaryKey(sysFile);
    }

    /**
     * @Title:
     * @Description: 批量修改菜单
     * @param sysFiles
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysFile> sysFiles){
        return super.updateListByPrimaryKey(sysFiles);
    }

    /**
     * @Title:
     * @Description: 动态修改菜单
     * @param sysFile
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysFile sysFile) {
        return super.updateByPrimaryKeySelective(sysFile);
    }

    /**
     * @Title:
     * @Description: 批量动态修改菜单
     * @param sysFiles
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysFile> sysFiles) {
        return super.updateListByPrimaryKeySelective(sysFiles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改菜单
     * @param sysFile
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int updateByExampleData(SysFile sysFile, Example example) {
        return super.updateByExample(sysFile,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改菜单
     * @param sysFile
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int updateByExampleSelectiveData(SysFile sysFile, Example example){
        return super.updateByExampleSelective(sysFile,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ID删除菜单
     * @param sysFile
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public int deleteData(SysFile sysFile) {
        return super.delete(sysFile);
    }

    /**
     * @Title:
     * @Description: 根据ID集合批量删除菜单
     * @param sysFile
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public int deleteDataList(List ids,SysFile sysFile){
        return super.deleteByIds(ids,sysFile);
    }

    /**
     * @Title:
     * @Description: 查询全部菜单
     * @return List<SysFile>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public List<SysFile> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个菜单
     * @param example
     * @return SysFile
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public SysFile selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询菜单
     * @param example
     * @return List<SysFile>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public List<SysFile> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ID查询菜单
     * @param id
     * @return SysFile
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public SysFile selectByPrimaryKey(Object id) {
        return super.selectByPrimaryKey(id);
    }
    
    /**
     * @Title:
     * @Description: 分页查询菜单
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysFile>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @Override
    public PageInfoExtend<SysFile> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询菜单vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysFile>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public PageInfoExtend<SysFile> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

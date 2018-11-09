package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysGroupParentDao;
import cn.com.leadu.fms.data.system.repository.SysGroupParentRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupParentRepositoryImpl
 * @Description: 用户组关系Repository 实现层
 * @date 2018-03-12
 */
@Repository
public class SysGroupParentRepositoryImpl extends AbstractBaseRepository<SysGroupParentDao, SysGroupParent> implements SysGroupParentRepository {

    /**
     * @Title:
     * @Description: 新增用户组关系
     * @param sysGroupParent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int insertData(SysGroupParent sysGroupParent) {
        return super.insert(sysGroupParent);
    }

    /**
     * @Title:
     * @Description: 批量保存用户组关系
     * @param sysGroupParents
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int insertDataList(List<SysGroupParent> sysGroupParents){
        return super.insertListByJdbcTemplate(sysGroupParents);
    }

    /**
     * @Title:
     * @Description: 通过条件删除
     * @param sysGroupParent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int deleteExampleData(Example example,SysGroupParent sysGroupParent){
        return super.deleteByExample(example,sysGroupParent);
    }

    /**
     * @Title:
     * @Description: 修改用户组关系
     * @param sysGroupParent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int updateByPrimaryKeyData(SysGroupParent sysGroupParent) {
        return super.updateByPrimaryKey(sysGroupParent);
    }

    /**
     * @Title:
     * @Description: 批量修改用户组关系
     * @param sysGroupParents
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysGroupParent> sysGroupParents){
        return super.updateListByPrimaryKey(sysGroupParents);
    }

    /**
     * @Title:
     * @Description: 动态修改用户组关系
     * @param sysGroupParent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysGroupParent sysGroupParent) {
        return super.updateByPrimaryKeySelective(sysGroupParent);
    }

    /**
     * @Title:
     * @Description: 批量动态修改用户组关系
     * @param sysGroupParents
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysGroupParent> sysGroupParents) {
        return super.updateListByPrimaryKeySelective(sysGroupParents);
    }

    /**
     * @Title:
     * @Description: 根据条件修改用户组关系
     * @param sysGroupParent
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int updateByExampleData(SysGroupParent sysGroupParent, Example example) {
        return super.updateByExample(sysGroupParent,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改用户组关系
     * @param sysGroupParent
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int updateByExampleSelectiveData(SysGroupParent sysGroupParent, Example example){
        return super.updateByExampleSelective(sysGroupParent,example);
    }
    
    /**
     * @Title:
     * @Description: 根据parentId删除用户组关系
     * @param sysGroupParent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public int deleteData(SysGroupParent sysGroupParent) {
        return super.delete(sysGroupParent);
    }

    /**
     * @Title:
     * @Description: 根据parentId集合批量删除用户组关系
     * @param sysGroupParent
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    public int deleteDataList(List parentIds,SysGroupParent sysGroupParent){
        return super.deleteByIds(parentIds,sysGroupParent);
    }

    /**
     * @Title:
     * @Description: 查询全部用户组关系
     * @return List<SysGroupParent>
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public List<SysGroupParent> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个用户组关系
     * @param example
     * @return SysGroupParent
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public SysGroupParent selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询用户组关系
     * @param example
     * @return List<SysGroupParent>
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public List<SysGroupParent> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过parentId查询用户组关系
     * @param parentId
     * @return SysGroupParent
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public SysGroupParent selectByPrimaryKey(Object parentId) {
        return super.selectByPrimaryKey(parentId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询用户组关系
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysGroupParent>
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public PageInfoExtend<SysGroupParent> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询用户组关系vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysGroupParent>
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    public PageInfoExtend<SysGroupParent> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

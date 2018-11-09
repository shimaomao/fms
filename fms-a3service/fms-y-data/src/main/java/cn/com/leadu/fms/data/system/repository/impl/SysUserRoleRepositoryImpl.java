package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysUserRoleDao;
import cn.com.leadu.fms.data.system.repository.SysUserRoleRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysUserRole;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserRoleRepositoryImpl
 * @Description: 用户角色管理Repository 实现层
 * @date 2018-03-22
 */
@Repository
public class SysUserRoleRepositoryImpl extends AbstractBaseRepository<SysUserRoleDao, SysUserRole> implements SysUserRoleRepository {

    /**
     * @Title:
     * @Description: 新增用户角色管理
     * @param sysUserRole
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int insertData(SysUserRole sysUserRole) {
        return super.insert(sysUserRole);
    }

    /**
     * @Title:
     * @Description: 批量保存用户角色管理
     * @param sysUserRoles
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int insertDataList(List<SysUserRole> sysUserRoles){
        return super.insertListByJdbcTemplate(sysUserRoles);
    }

    /**
     * @Title:
     * @Description: 修改用户角色管理
     * @param sysUserRole
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int updateByPrimaryKeyData(SysUserRole sysUserRole) {
        return super.updateByPrimaryKey(sysUserRole);
    }

    /**
     * @Title:
     * @Description: 批量修改用户角色管理
     * @param sysUserRoles
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysUserRole> sysUserRoles){
        return super.updateListByPrimaryKey(sysUserRoles);
    }

    /**
     * @Title:
     * @Description: 动态修改用户角色管理
     * @param sysUserRole
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysUserRole sysUserRole) {
        return super.updateByPrimaryKeySelective(sysUserRole);
    }

    /**
     * @Title:
     * @Description: 批量动态修改用户角色管理
     * @param sysUserRoles
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysUserRole> sysUserRoles) {
        return super.updateListByPrimaryKeySelective(sysUserRoles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改用户角色管理
     * @param sysUserRole
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int updateByExampleData(SysUserRole sysUserRole, Example example) {
        return super.updateByExample(sysUserRole,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改用户角色管理
     * @param sysUserRole
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int updateByExampleSelectiveData(SysUserRole sysUserRole, Example example){
        return super.updateByExampleSelective(sysUserRole,example);
    }
    
    /**
     * @Title:
     * @Description: 根据userId删除用户角色管理
     * @param sysUserRole
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public int deleteData(SysUserRole sysUserRole) {
        return super.delete(sysUserRole);
    }

    /**
     * @Title:
     * @Description: 根据userId集合批量删除用户角色管理
     * @param sysUserRole
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    public int deleteDataList(List userIds,SysUserRole sysUserRole){
        return super.deleteByIds(userIds,sysUserRole);
    }

    /**
     * 根据条件批量删除
     * @param example
     * @param sysUserRole
     * @return
     */
    @Override
    public int deleteExampleData(Example example, SysUserRole sysUserRole) {
        return super.deleteByExample(example,sysUserRole);
    }

    /**
     * @Title:
     * @Description: 查询全部用户角色管理
     * @return List<SysUserRole>
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public List<SysUserRole> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个用户角色管理
     * @param example
     * @return SysUserRole
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public SysUserRole selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询用户角色管理
     * @param example
     * @return List<SysUserRole>
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public List<SysUserRole> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过userId查询用户角色管理
     * @param userId
     * @return SysUserRole
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public SysUserRole selectByPrimaryKey(Object userId) {
        return super.selectByPrimaryKey(userId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询用户角色管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysUserRole>
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    @Override
    public PageInfoExtend<SysUserRole> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询用户角色管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysUserRole>
     * @throws
     * @author ningyangyang
     * @date 2018-3-22 11:15:21
     */
    public PageInfoExtend<SysUserRole> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}

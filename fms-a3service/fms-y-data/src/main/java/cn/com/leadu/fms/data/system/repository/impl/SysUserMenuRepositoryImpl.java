package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysUserMenuDao;
import cn.com.leadu.fms.data.system.repository.SysUserMenuRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuRepositoryImpl
 * @Description: 用户角色设置Repository 实现层
 * @date 2018-03-17
 */
@Repository
public class SysUserMenuRepositoryImpl extends AbstractBaseRepository<SysUserMenuDao, SysUserMenu> implements SysUserMenuRepository {

    /**
     * @Title:
     * @Description: 新增用户角色设置
     * @param sysUserMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int insertData(SysUserMenu sysUserMenu) {
        return super.insert(sysUserMenu);
    }

    /**
     * @Title:
     * @Description: 批量保存用户角色设置
     * @param sysUserMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int insertDataList(List<SysUserMenu> sysUserMenus){
        return super.insertListByJdbcTemplate(sysUserMenus);
    }

    /**
     * @Title:
     * @Description: 修改用户角色设置
     * @param sysUserMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int updateByPrimaryKeyData(SysUserMenu sysUserMenu) {
        return super.updateByPrimaryKey(sysUserMenu);
    }

    /**
     * @Title:
     * @Description: 批量修改用户角色设置
     * @param sysUserMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysUserMenu> sysUserMenus){
        return super.insertListByJdbcTemplate(sysUserMenus);
    }

    /**
     * @Title:
     * @Description: 动态修改用户角色设置
     * @param sysUserMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysUserMenu sysUserMenu) {
        return super.updateByPrimaryKeySelective(sysUserMenu);
    }

    /**
     * @Title:
     * @Description: 批量动态修改用户角色设置
     * @param sysUserMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysUserMenu> sysUserMenus) {
        return super.updateListByPrimaryKeySelective(sysUserMenus);
    }

    /**
     * @Title:
     * @Description: 根据条件修改用户角色设置
     * @param sysUserMenu
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int updateByExampleData(SysUserMenu sysUserMenu, Example example) {
        return super.updateByExample(sysUserMenu,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改用户角色设置
     * @param sysUserMenu
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int updateByExampleSelectiveData(SysUserMenu sysUserMenu, Example example){
        return super.updateByExampleSelective(sysUserMenu,example);
    }
    /**
     *  根据条件删除
     * @param example
     * @param sysUserMenu
     * @return
     */
    public int deleteExampleData(Example example,SysUserMenu sysUserMenu){

        return super.deleteByExample(example,sysUserMenu);
    }
    /**
     * @Title:
     * @Description: 根据userMenuId删除用户角色设置
     * @param sysUserMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public int deleteData(SysUserMenu sysUserMenu) {
        return super.delete(sysUserMenu);
    }

    /**
     * @Title:
     * @Description: 根据userMenuId集合批量删除用户角色设置
     * @param sysUserMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    public int deleteDataList(List userMenuIds,SysUserMenu sysUserMenu){
        return super.deleteByIds(userMenuIds,sysUserMenu);
    }

    /**
     * @Title:
     * @Description: 查询全部用户角色设置
     * @return List<SysUserMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public List<SysUserMenu> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个用户角色设置
     * @param example
     * @return SysUserMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public SysUserMenu selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询用户角色设置
     * @param example
     * @return List<SysUserMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public List<SysUserMenu> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过userMenuId查询用户角色设置
     * @param userMenuId
     * @return SysUserMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public SysUserMenu selectByPrimaryKey(Object userMenuId) {
        return super.selectByPrimaryKey(userMenuId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询用户角色设置
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysUserMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Override
    public PageInfoExtend<SysUserMenu> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询用户角色设置vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysUserMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    public PageInfoExtend<SysUserMenu> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * 根据用户id删除菜单
     * @param userId
     * @return
     */
    @Override
    public Integer deleteUserMenusByUserId(String userId) {
        return baseDao.deleteUserMenusByUserId(userId);
    }

}

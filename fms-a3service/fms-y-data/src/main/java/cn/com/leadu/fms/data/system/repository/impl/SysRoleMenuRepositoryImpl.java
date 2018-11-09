package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysRoleMenuDao;
import cn.com.leadu.fms.data.system.repository.SysRoleMenuRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuRepositoryImpl
 * @Description: 菜单角色设置Repository 实现层
 * @date 2018-03-15
 */
@Repository
public class SysRoleMenuRepositoryImpl extends AbstractBaseRepository<SysRoleMenuDao, SysRoleMenu> implements SysRoleMenuRepository {

    /**
     * @Title:
     * @Description: 新增菜单角色设置
     * @param sysRoleMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int insertData(SysRoleMenu sysRoleMenu) {
        return super.insert(sysRoleMenu);
    }

    /**
     * @Title:
     * @Description: 批量保存菜单角色设置
     * @param sysRoleMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int insertDataList(List<SysRoleMenu> sysRoleMenus){
        return super.insertListByJdbcTemplate(sysRoleMenus);
    }

    /**
     * @Title:
     * @Description: 修改菜单角色设置
     * @param sysRoleMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int updateByPrimaryKeyData(SysRoleMenu sysRoleMenu) {
        return super.updateByPrimaryKey(sysRoleMenu);
    }

    /**
     * @Title:
     * @Description: 批量修改菜单角色设置
     * @param sysRoleMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysRoleMenu> sysRoleMenus){
        return super.insertListByJdbcTemplate(sysRoleMenus);
    }

    /**
     * @Title:
     * @Description: 动态修改菜单角色设置
     * @param sysRoleMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysRoleMenu sysRoleMenu) {
        return super.updateByPrimaryKeySelective(sysRoleMenu);
    }

    /**
     * @Title:
     * @Description: 批量动态修改菜单角色设置
     * @param sysRoleMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysRoleMenu> sysRoleMenus) {
        return super.updateListByPrimaryKeySelective(sysRoleMenus);
    }

    /**
     * @Title:
     * @Description: 根据条件修改菜单角色设置
     * @param sysRoleMenu
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int updateByExampleData(SysRoleMenu sysRoleMenu, Example example) {
        return super.updateByExample(sysRoleMenu,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改菜单角色设置
     * @param sysRoleMenu
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int updateByExampleSelectiveData(SysRoleMenu sysRoleMenu, Example example){
        return super.updateByExampleSelective(sysRoleMenu,example);
    }
    
    /**
     * @Title:
     * @Description: 根据roleMenuId删除菜单角色设置
     * @param sysRoleMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public int deleteData(SysRoleMenu sysRoleMenu) {
        return super.delete(sysRoleMenu);
    }

    /**
     * @Title:
     * @Description:   根据条件删除
     * @param example
     * @param sysRoleMenu
     * @return
     * @throws
     *
     * @author QianHuaSheng
     * @date 2018/03/21 02:28:57
     */
    public int deleteExampleData(Example example,SysRoleMenu sysRoleMenu){
        return super.deleteByExample(example,sysRoleMenu);
    }

    /**
     * @Title:
     * @Description: 根据roleMenuId集合批量删除菜单角色设置
     * @param sysRoleMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    public int deleteDataList(List roleMenuIds,SysRoleMenu sysRoleMenu){
        return super.deleteByIds(roleMenuIds,sysRoleMenu);
    }

    /**
     * @Title:
     * @Description: 查询全部菜单角色设置
     * @return List<SysRoleMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public List<SysRoleMenu> selectAll() {
        return super.selectAll();
    }


    /**
     * @Title:
     * @Description: 通过条件查询一个菜单角色设置
     * @param example
     * @return SysRoleMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public SysRoleMenu selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询菜单角色设置
     * @param example
     * @return List<SysRoleMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public List<SysRoleMenu> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过roleMenuId查询菜单角色设置
     * @param roleMenuId
     * @return SysRoleMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public SysRoleMenu selectByPrimaryKey(Object roleMenuId) {
        return super.selectByPrimaryKey(roleMenuId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询菜单角色设置
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysRoleMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Override
    public PageInfoExtend<SysRoleMenu> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询菜单角色设置vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysRoleMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    public PageInfoExtend<SysRoleMenu> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * 根据角色id删除角色菜单表内容
     * @param roleId
     * @return
     */
    @Override
    public Integer deleteRoleMenusByRoleId(String roleId) {

        return baseDao.deleteRoleMenusByRoleId(roleId);
    }

//    /**
//     * 根据角色id更新菜单
//     * @param roleId
//     * @param menuIds
//     * @return
//     */
//    @Override
//    public Integer insertRoleMenuByRoleId(String roleId, List<String> menuIds) {
//
//        return  baseDao.insertRoleMenuByRoleId(roleId,menuIds);
//    }

}

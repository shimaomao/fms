package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysMenuDao;
import cn.com.leadu.fms.data.system.repository.SysMenuRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuRepositoryImpl
 * @Description: 系统菜单Repository 实现层
 * @date 2018-03-07
 */
@Repository
public class SysMenuRepositoryImpl extends AbstractBaseRepository<SysMenuDao, SysMenu> implements SysMenuRepository {

    /**
     * @Title:
     * @Description: 新增系统菜单
     * @param sysMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int insertData(SysMenu sysMenu) {
        return super.insert(sysMenu);
    }

    /**
     * @Title:
     * @Description: 批量保存系统菜单
     * @param sysMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int insertDataList(List<SysMenu> sysMenus){
        return super.insertListByJdbcTemplate(sysMenus);
    }

    /**
     * @Title:
     * @Description: 修改系统菜单
     * @param sysMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int updateByPrimaryKeyData(SysMenu sysMenu) {
        return super.updateByPrimaryKey(sysMenu);
    }

    /**
     * @Title:
     * @Description: 批量修改系统菜单
     * @param sysMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysMenu> sysMenus){
        return super.insertListByJdbcTemplate(sysMenus);
    }

    /**
     * @Title:
     * @Description: 动态修改系统菜单
     * @param sysMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysMenu sysMenu) {
        return super.updateByPrimaryKeySelective(sysMenu);
    }

    /**
     * @Title:
     * @Description: 批量动态修改系统菜单
     * @param sysMenus
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysMenu> sysMenus) {
        return super.updateListByPrimaryKeySelective(sysMenus);
    }

    /**
     * @Title:
     * @Description: 根据条件修改系统菜单
     * @param sysMenu
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int updateByExampleData(SysMenu sysMenu, Example example) {
        return super.updateByExample(sysMenu,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改系统菜单
     * @param sysMenu
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int updateByExampleSelectiveData(SysMenu sysMenu, Example example){
        return super.updateByExampleSelective(sysMenu,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ID删除系统菜单
     * @param sysMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public int deleteData(SysMenu sysMenu) {
        return super.delete(sysMenu);
    }

    /**
     * @Title:
     * @Description: 根据ID集合批量删除系统菜单
     * @param sysMenu
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    public int deleteDataList(List ids,SysMenu sysMenu){
        return super.deleteByIds(ids,sysMenu);
    }

    /**
     * @Title:
     * @Description: 查询全部系统菜单
     * @return List<SysMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public List<SysMenu> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个系统菜单
     * @param example
     * @return SysMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public SysMenu selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询系统菜单
     * @param example
     * @return List<SysMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public List<SysMenu> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ID查询系统菜单
     * @param id
     * @return SysMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public SysMenu selectByPrimaryKey(Object id) {
        return super.selectByPrimaryKey(id);
    }
    
    /**
     * @Title:
     * @Description: 分页查询系统菜单
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Override
    public PageInfoExtend<SysMenu> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询系统菜单vo
     * @param sysMenuVo
     * @param pageQuery
     * @return PageInfoExtend<SysMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    public PageInfoExtend<SysMenuVo> selectListVoByPage(String methodName,SysMenuVo sysMenuVo, PageQuery pageQuery){
        return super.selectListVoByPage(methodName,sysMenuVo,pageQuery);
    }

    /**
     * 根据角色id获取菜单
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> selectSysMenusByRoleId(String roleId) {
        return baseDao.selectSysMenusByRoleId(roleId);
    }

    /**
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> selectSysMenusByUserId(String userId) {

        return baseDao.selectSysMenusByUserId(userId);
    }

    /**
     * @Title:
     * @Description:   根据角色id集合获取对应菜单信息
     * @param roleIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/22 02:08:12
     */
    public List<SysMenu> selectSysMenusByRoleIds(List<String> roleIds){
        return baseDao.selectSysMenusByRoleIds(roleIds);
    }

}

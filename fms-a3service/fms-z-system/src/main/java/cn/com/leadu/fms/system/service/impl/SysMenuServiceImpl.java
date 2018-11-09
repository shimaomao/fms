package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.common.constant.enums.system.SysUserValidMenuTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysMenuRepository;
import cn.com.leadu.fms.data.system.repository.SysRoleMenuRepository;
import cn.com.leadu.fms.data.system.repository.SysUserMenuRepository;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
import cn.com.leadu.fms.system.service.SysMenuService;
import cn.com.leadu.fms.system.service.SysRoleService;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuService
 * @Description: 系统菜单业务实现层
 * @date 2018-03-07
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    /**
     * @Fields  : 系统菜单repository
     */
    @Autowired
    private SysMenuRepository sysMenuRepository;

    /**
     * @Fields  : 系统角色service
     */
    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;

    @Autowired
    private SysUserMenuRepository sysUserMenuRepository;

    /**
     * @Title:
     * @Description: 保存系统菜单
     * @param sysMenuSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Transactional
    public void saveSysMenu(SysMenuSaveVo sysMenuSaveVo){
            sysMenuRepository.insertData(sysMenuSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改系统菜单
     * @param sysMenuModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Transactional
    public void modifySysMenu(SysMenuModifyVo sysMenuModifyVo){
            sysMenuRepository.updateByPrimaryKeySelectiveData(sysMenuModifyVo.getEntity());

    }

    /**
     * @Title:
     * @Description:  通过id删除系统菜单
     * @param sysMenuDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Transactional
    public void deleteSysMenu(SysMenuDeleteVo sysMenuDeleteVo){
        sysMenuRepository.deleteData(sysMenuDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过id集合删除系统菜单
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @Transactional
    public void deleteSysMenuByMenuIds(SysMenuVo sysMenuVo){
        Example ex1 = SqlUtil.newExample(SysMenu.class);
        for(String menuId:sysMenuVo.getMenuIds()){
            ex1.createCriteria().andEqualTo("parMenuId",menuId);
           List<SysMenu> list =  sysMenuRepository.selectListByExample(ex1);
            if(list.size()!=0){
                throw  new FmsServiceException("不可直接删除父级菜单");
            }
        }
        Example ex2 = SqlUtil.newExample(SysRoleMenu.class);
        for(String menuId:sysMenuVo.getMenuIds()){
            ex2.createCriteria().andEqualTo("menuId",menuId);
            sysRoleMenuRepository.deleteExampleData(ex2,new SysRoleMenu());
        }
        Example ex3 = SqlUtil.newExample(SysUserMenu.class);
        for(String menuId:sysMenuVo.getMenuIds()){
            ex3.createCriteria().andEqualTo("menuId",menuId);
            sysUserMenuRepository .deleteExampleData(ex2,new SysUserMenu());
        }
        sysMenuRepository.deleteDataList(sysMenuVo.getMenuIds(),sysMenuVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据id系统菜单
     * @param menuId
     * @return SysMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    public SysMenu findSysMenuByMenuId(String menuId){
        return sysMenuRepository.selectByPrimaryKey(menuId);
    }

    /**
     * @Title:
     * @Description: 分页查询系统菜单
     * @param sysMenuVo
     * @return PageInfoExtend<SysMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    public PageInfoExtend<SysMenuVo> findSysMenuVosByPage(SysMenuVo sysMenuVo){
        if(StringUtils.isNotTrimBlank(sysMenuVo.getMenuName()))
            sysMenuVo.setMenuName(SqlUtil.likePattern(sysMenuVo.getMenuName()));
        else
            sysMenuVo.setMenuName(null);
        if (StringUtils.isNotTrimBlank(sysMenuVo.getMenuLevel()))
            sysMenuVo.setMenuLevel(sysMenuVo.getMenuLevel());
        else
            sysMenuVo.setMenuLevel(null);

        //上级菜单
        if(StringUtils.isNotTrimBlank(sysMenuVo.getParMenuName()))
            sysMenuVo.setParMenuName(SqlUtil.likePattern(sysMenuVo.getParMenuName()));
        else
            sysMenuVo.setParMenuName(null);
        return sysMenuRepository.selectListVoByPage("selectSysMenuVosByPage",sysMenuVo,sysMenuVo.getPageQuery());
    }

    /**
     * 根据菜单等级获取菜单
     * @param resLevel
     * @return
     */
    public List<SysMenu> findSysResourceIsParent(String resLevel){
        Example example = SqlUtil.newExample(SysMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("menuLevel",resLevel);
        SqlUtil.andEqualToDeleteExist(criteria);
        return sysMenuRepository.selectListByExample(example);
    }

    /**
     * 根据角色id获取菜单
     * @param roleId
     * @return
     */
    public List<BootstrapTreeViewNodeVo> findSysMenusByRoleId(String roleId){
          List<SysMenu> menusList =  sysMenuRepository.selectSysMenusByRoleId(roleId);
         List<SysMenu> allMenuList  = sysMenuRepository.selectAll();
         return CommonTreeDataUtils.getTrees(CommonTreeDataUtils.getParentsResults(allMenuList,menusList)) ;
    }

    /**
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    @Override
    public List<BootstrapTreeViewNodeVo> findSysMenusByUserId(String userId) {
       List<SysMenu> menuList = CommonTreeDataUtils.getParentsResults(sysMenuRepository.selectAll(),sysMenuRepository.selectSysMenusByUserId(userId));
        return CommonTreeDataUtils.getTrees(menuList);
    }

    /**
     * @Title:
     * @Description: 根据用户id和菜单权限类型
     * @param userId
     * @param validMenuType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/22 11:28:09
     */
    public List<SysMenu> findSysMenusByUserId(String userId, String validMenuType){
        List<SysMenu> sysMenus = null;
        List<SysMenu> sysMenusPar = null;
        List<SysMenu> allMenus = sysMenuRepository.selectAll();
        if(StringUtils.isNotTrimBlank(userId,validMenuType)){
            //角色控制菜单
            if (SysUserValidMenuTypeEnums.ROLE_CONTROLLER.getType().equals(validMenuType)) {
                // 角色控制
                List<String> roleIds = sysRoleService.findSysRoleIdsBySysUserId(userId);
                if(ArrayUtils.isNotNullAndLengthNotZero(roleIds)){
                    sysMenus = sysMenuRepository.selectSysMenusByRoleIds(roleIds);
                }
            }else{
                //用户控制菜单
                sysMenus = sysMenuRepository.selectSysMenusByUserId(userId);
            }
            sysMenusPar = CommonTreeDataUtils.getParentsResults(allMenus,sysMenus);
        }
        return sysMenusPar;
    }

    /**
     * @Title:
     * @Description:   根据父级id获取下级菜单
     * @param parMenuId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 12:09:04
     */
    public List<SysMenu> findSysMenusByParMenuId(String parMenuId){
        List<SysMenu> sysMenus = CommonTreeDataUtils.getChildResults(sysMenuRepository.selectAll(),parMenuId);
        return sysMenus;
    }

    /**
     * 根据角色id获取所有菜单并勾选
     * @return
     */
    @Override
    public List<BootstrapTreeViewNodeVo> findAllMenusByRoleId(String roleId) {
        List<SysMenu> menuList = sysMenuRepository.selectSysMenusByRoleId(roleId);
        List<BootstrapTreeViewNodeVo> menuTreeList;

        if(menuList.size()>0){
             menuTreeList = CommonTreeDataUtils.getTrees(sysMenuRepository.selectAll(),menuList);
        }else{

            menuTreeList = CommonTreeDataUtils.getTrees(sysMenuRepository.selectAll());
        }
        return menuTreeList;
    }

    /**
     * 根据用户id获取所有菜单并勾选已有菜单
     * @param userId
     * @return
     */
    @Override
    public List<BootstrapTreeViewNodeVo> findAllMenusByUserId(String userId) {
        List<SysMenu> menuList = sysMenuRepository.selectSysMenusByUserId(userId);
        List<BootstrapTreeViewNodeVo> menuTreeList;

        if(menuList.size()>0){
            menuTreeList = CommonTreeDataUtils.getTrees(sysMenuRepository.selectAll(),menuList);
        }else{

            menuTreeList = CommonTreeDataUtils.getTrees(sysMenuRepository.selectAll());
        }
        return menuTreeList;
    }

}

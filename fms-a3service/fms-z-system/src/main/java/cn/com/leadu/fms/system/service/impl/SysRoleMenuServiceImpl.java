package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysRoleMenuRepository;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.pojo.system.vo.sysrolemenu.SysRoleMenuVo;
import cn.com.leadu.fms.system.service.SysRoleMenuService;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuDeleteListVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuService
 * @Description: 菜单角色设置业务实现层
 * @date 2018-03-15
 */
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    /**
     * @Fields  : 菜单角色设置repository
     */
    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;

    /**
     * @Title:
     * @Description: 分页查询菜单角色设置
     * @param sysRoleMenuVo
     * @return PageInfoExtend<SysRoleMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    public PageInfoExtend<SysRoleMenu> findSysRoleMenusByPage(SysRoleMenuVo sysRoleMenuVo){
        Example example = SqlUtil.newExample(SysRoleMenu.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysRoleMenu> pageInfo = sysRoleMenuRepository.selectListByExamplePage(example,sysRoleMenuVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存菜单角色设置
     * @param sysRoleMenuSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Transactional
    public void saveSysRoleMenu(SysRoleMenuSaveVo sysRoleMenuSaveVo){
        sysRoleMenuRepository.insertData(sysRoleMenuSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改菜单角色设置
     * @param sysRoleMenuModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Transactional
    public void modifySysRoleMenu(SysRoleMenuModifyVo sysRoleMenuModifyVo){
        sysRoleMenuRepository.updateByPrimaryKeySelectiveData(sysRoleMenuModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过roleMenuId删除菜单角色设置
     * @param sysRoleMenuDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Transactional
    public void deleteSysRoleMenu(SysRoleMenuDeleteVo sysRoleMenuDeleteVo){
        sysRoleMenuRepository.deleteData(sysRoleMenuDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过roleMenuId集合删除菜单角色设置
     * @param sysRoleMenuDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @Transactional
    public void deleteSysRoleMenusByRoleMenuIds(SysRoleMenuDeleteListVo sysRoleMenuDeleteListVo){
        sysRoleMenuRepository.deleteDataList(sysRoleMenuDeleteListVo.getRoleMenuIds(),sysRoleMenuDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据roleMenuId获取菜单角色设置
     * @param roleMenuId
     * @return SysRoleMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    public SysRoleMenu findSysRoleMenuByRoleMenuId(String roleMenuId){
        return sysRoleMenuRepository.selectByPrimaryKey(roleMenuId);
    }

    /**
     * 根据角色重新分配菜单
     * @param
     * @param
     */
    @Override
    @Transactional
    public void updateSysRoleMenuByRoleId(List<SysRoleMenu> sysRoleMenus) {

        Example example = SqlUtil.newExample(SysRoleMenu.class);
        example.createCriteria().andEqualTo("roleId",sysRoleMenus.get(0).getRoleId());
        List<SysRoleMenu> roleMenuGetList = sysRoleMenuRepository.selectListByExample(example);//后台原有菜单
        //List<GuaranteePers>  CstmContactGetList =  guaranteePersRepository.selectListByExample(example);
        List<SysRoleMenu> CstmContactAddList = new ArrayList<>();
        List<SysRoleMenu> CstmContactKeepList = new ArrayList<>();
        if(sysRoleMenus.size()!=0){
            //CstmContactGetList.removeAll(cstmContactList);
            for(SysRoleMenu cstmcon:sysRoleMenus){
                if(cstmcon.getRoleMenuId()==null){
                    //cstmcon.setApplyNo(applyNo);
                    CstmContactAddList.add(cstmcon);
                }
                if(roleMenuGetList.size()!=0){
                    for(SysRoleMenu con:roleMenuGetList){
                        if(con.getRoleId().equals(cstmcon.getRoleId())&&con.getMenuId().equals(cstmcon.getMenuId())){
                            CstmContactKeepList.add(con);
                        }
                    }
                }
            }
            roleMenuGetList.removeAll(CstmContactKeepList); //要删除的
            if(roleMenuGetList.size()>0){
                for(SysRoleMenu con: roleMenuGetList){
                    sysRoleMenuRepository.deleteData(con);
                }
            }
            sysRoleMenuRepository.insertDataList(CstmContactAddList);
        }else{
            sysRoleMenuRepository.deleteExampleData(example,new SysRoleMenu());
        }


       // sysRoleMenuRepository.deleteExampleData(example,new SysRoleMenu());
        //sysRoleMenuRepository.insertDataList(sysRoleMenus);
    }

}

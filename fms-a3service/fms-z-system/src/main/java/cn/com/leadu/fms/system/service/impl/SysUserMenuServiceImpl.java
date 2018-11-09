package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysUserMenuRepository;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.pojo.system.vo.sysusermenu.SysUserMenuVo;
import cn.com.leadu.fms.system.service.SysUserMenuService;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuDeleteListVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuService
 * @Description: 用户角色设置业务实现层
 * @date 2018-03-17
 */
@Service
public class SysUserMenuServiceImpl implements SysUserMenuService {

    /**
     * @Fields  : 用户角色设置repository
     */
    @Autowired
    private SysUserMenuRepository sysUserMenuRepository;

    /**
     * @Title:
     * @Description: 分页查询用户角色设置
     * @param sysUserMenuVo
     * @return PageInfoExtend<SysUserMenu>
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    public PageInfoExtend<SysUserMenu> findSysUserMenusByPage(SysUserMenuVo sysUserMenuVo){
        Example example = SqlUtil.newExample(SysUserMenu.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysUserMenu> pageInfo = sysUserMenuRepository.selectListByExamplePage(example,sysUserMenuVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存用户角色设置
     * @param sysUserMenuSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Transactional
    public void saveSysUserMenu(SysUserMenuSaveVo sysUserMenuSaveVo){
        sysUserMenuRepository.insertData(sysUserMenuSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改用户角色设置
     * @param sysUserMenuModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Transactional
    public void modifySysUserMenu(SysUserMenuModifyVo sysUserMenuModifyVo){
        sysUserMenuRepository.updateByPrimaryKeySelectiveData(sysUserMenuModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过userMenuId删除用户角色设置
     * @param sysUserMenuDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Transactional
    public void deleteSysUserMenu(SysUserMenuDeleteVo sysUserMenuDeleteVo){
        sysUserMenuRepository.deleteData(sysUserMenuDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过userMenuId集合删除用户角色设置
     * @param sysUserMenuDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @Transactional
    public void deleteSysUserMenusByUserMenuIds(SysUserMenuDeleteListVo sysUserMenuDeleteListVo){
        sysUserMenuRepository.deleteDataList(sysUserMenuDeleteListVo.getUserMenuIds(),sysUserMenuDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据userMenuId获取用户角色设置
     * @param userMenuId
     * @return SysUserMenu
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    public SysUserMenu findSysUserMenuByUserMenuId(String userMenuId){
        return sysUserMenuRepository.selectByPrimaryKey(userMenuId);
    }

    /**
     * 根据用户id更新菜单
     * @param sysUserMenus
     */
    @Override
    @Transactional
    public void updateSysUserMenuByUserId(List<SysUserMenu> sysUserMenus) {
           Example example =  SqlUtil.newExample(SysUserMenu.class);
           example.createCriteria().andEqualTo("userId",sysUserMenus.get(0).getUserId());

        List<SysUserMenu> roleMenuGetList = sysUserMenuRepository.selectListByExample(example);//后台原有菜单
        //List<GuaranteePers>  CstmContactGetList =  guaranteePersRepository.selectListByExample(example);
        List<SysUserMenu> CstmContactAddList = new ArrayList<>();
        List<SysUserMenu> CstmContactKeepList = new ArrayList<>();
        if(sysUserMenus.size()!=0){
            //CstmContactGetList.removeAll(cstmContactList);
            for(SysUserMenu cstmcon:sysUserMenus){
                if(cstmcon.getUserMenuId()==null){
                    //cstmcon.setApplyNo(applyNo);
                    CstmContactAddList.add(cstmcon);
                }
                if(roleMenuGetList.size()!=0){
                    for(SysUserMenu con:roleMenuGetList){
                        if(con.getUserId().equals(cstmcon.getUserId())&&con.getMenuId().equals(cstmcon.getMenuId())){
                            CstmContactKeepList.add(con);
                        }
                    }
                }
            }
            roleMenuGetList.removeAll(CstmContactKeepList); //要删除的
            if(roleMenuGetList.size()>0){
                for(SysUserMenu con: roleMenuGetList){
                    sysUserMenuRepository.deleteData(con);
                }
            }
            sysUserMenuRepository.insertDataList(CstmContactAddList);
        }else{
            sysUserMenuRepository.deleteExampleData(example,new SysUserMenu());
        }



        //sysUserMenuRepository.deleteExampleData(example,new SysUserMenu());
           //sysUserMenuRepository.insertDataList(sysUserMenus);
    }

}

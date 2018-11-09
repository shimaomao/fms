package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.constant.enums.system.SysResourceEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysResourceLevelEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysUserValidMenuTypeEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysResourceRepository;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import cn.com.leadu.fms.pojo.system.vo.sysresource.SysResourceVo;
import cn.com.leadu.fms.system.service.SysResourceService;
import cn.com.leadu.fms.system.service.SysRoleService;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceDeleteListVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceDeleteVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceModifyVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceSaveVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceServiceImpl
 * @Description:
 * @date 2018/1/14
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceRepository sysResourceRepository;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * @Title:
     * @Description: 根据用户id返回拥有的菜单
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:48:19
     */
    public List<SysResource> findSysResourceByUser(String sysUserId, String validMenuType){
        List<SysResource> sysResources = null;
        if(StringUtils.isNotTrimBlank(sysUserId) && StringUtils.isNotTrimBlank(validMenuType)) {
            if (SysUserValidMenuTypeEnums.ROLE_CONTROLLER.getType().equals(validMenuType)) {
                // 角色控制
                List<String> roleIds = sysRoleService.findSysRoleIdsBySysUserId(sysUserId);
                if (ArrayUtils.isNotNullAndLengthNotZero(roleIds))
                    sysResources = sysResourceRepository.selectSysResMenusBySysRoleIds(roleIds, SysResourceEnums.MENU.getType());
            } else {
                // 用户控制
                sysResources = sysResourceRepository.selectSysResMenusBySysUserId(sysUserId, SysResourceEnums.MENU.getType());
            }
        }
        return sysResources;
    }

    /**
     * @Title:
     * @Description:  查询所有菜单列表, 根据sort资源排序
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 03:58:27
     */
    public List<SysResourceVo> findSysResourceAll(){
        Example example = SqlUtil.newExample(SysResource.class);
        SqlUtil.andEqualToDeleteExist(example.createCriteria());
        SqlUtil.setOrderByCreateTimeAsc(example);
        List<SysResource> sysResources = sysResourceRepository.selectListByExample(example);
        List<SysResourceVo> sysResourceVos = new ArrayList<>();
        for(SysResource sysResource : sysResources){
            //一级菜单
            if(sysResource.getResLevel().equals(SysResourceLevelEnums.ONE.getLevel())){
                SysResourceVo tmpVo = new SysResourceVo();
                BeanUtils.copyProperties(sysResource,tmpVo);
                sysResourceVos.add(tmpVo);
                //拿到下方的子菜单
                tmpVo.setChildren(findSysResourceAllChildren(tmpVo.getId(),sysResources));
            }
        }
        return sysResourceVos;
    }


    /**
     * @Title:
     * @Description:   获取自己的子菜单
     * @param parentId
     * @param sysResources
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/24 03:28:05
     */
    private List<SysResourceVo> findSysResourceAllChildren(String parentId,List<SysResource> sysResources){
        List<SysResourceVo> sysResourceVos = new ArrayList<>();
        for(SysResource sysResource : sysResources){
            if(StringUtils.isNotTrimBlank(sysResource.getParentId()) && sysResource.getParentId().equals(parentId)){
                SysResourceVo tmpVo = new SysResourceVo();
                BeanUtils.copyProperties(sysResource,tmpVo);
                sysResourceVos.add(tmpVo);
                //二级菜单
                if(sysResource.getResLevel().equals(SysResourceLevelEnums.TWO.getLevel())){
                    //拿到下方的子菜单
                    tmpVo.setChildren(findSysResourceAllChildren(tmpVo.getId(),sysResources));
                }
            }
        }
        return sysResourceVos;
    }


    /**
     * @Title:
     * @Description: 分页查询菜单 并按录入时间倒序
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:31:12
     */
    public PageInfoExtend<SysResource> findSysResourceByPage(SysResourceVo sysResourceVo){
        Example example = SqlUtil.newExample(SysResource.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(sysResourceVo.getDescription()))
            criteria.andLike("description",SqlUtil.likePattern(sysResourceVo.getDescription()));
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysResource> pageInfo = sysResourceRepository.selectListByExamplePage(example,sysResourceVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据角色id获取角色的菜单资源
     * @param sysRoleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 11:39:34
     */
    public List<SysResource> findSysResourceBySysRoleId(String sysRoleId){
        return sysResourceRepository.selectListBySysRoleId(sysRoleId, SysResourceEnums.MENU.getType());
    }


    /**
     * @Title:
     * @Description: 保存菜单资源
     * @param sysResourceSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:17:25
     */
    public void saveSysResource(SysResourceSaveVo sysResourceSaveVo){
        sysResourceRepository.insertData(sysResourceSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改菜单资源
     * @param sysResourceModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:50:35
     */
    public void modifySysResource(SysResourceModifyVo sysResourceModifyVo){
        sysResourceRepository.updateByPrimaryKeySelectiveData(sysResourceModifyVo.getEntity());
    }


    /**
     * @Title:
     * @Description:  通过id删除菜单资源
     * @param sysResourceDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:55:21
     */
    public void deleteSysResource(SysResourceDeleteVo sysResourceDeleteVo){
        sysResourceRepository.deleteData(sysResourceDeleteVo.getEntity());
    }


    /**
     * @Title:
     * @Description:  根据id集合删除菜单资源
     * @param sysResourceDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    public void deleteSysResourceByIds(SysResourceDeleteListVo sysResourceDeleteListVo){
        sysResourceRepository.deleteDataList(sysResourceDeleteListVo.getIds(),sysResourceDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据id获取资源菜单
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:32:58
     */
    public SysResource findSysResourceById(String id){
        return sysResourceRepository.selectByPrimaryKey(id);
    }


    /**
     * @Title:
     * @Description:  根据菜单级别获取菜单集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/18 10:24:47
     */
    public List<SysResource> findSysResourceIsParent(Integer resLevel){
        if(resLevel == null)
            resLevel = SysResourceLevelEnums.ONE.getLevel();
        Example example = SqlUtil.newExample(SysResource.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("resLevel",resLevel);
        SqlUtil.andEqualToDeleteExist(criteria);
        return sysResourceRepository.selectListByExample(example);
    }

}

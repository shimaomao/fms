package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysRoleResourceRepository;
import cn.com.leadu.fms.pojo.system.entity.SysRoleResource;
import cn.com.leadu.fms.system.service.SysRoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleResourceServiceImpl
 * @Description: 角色菜单关联service 实现类
 * @date 2018/3/7
 */
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

    @Autowired
    private SysRoleResourceRepository sysRoleResourceRepository;

    /**
     * @Title:
     * @Description:   批量保存角色菜单
     * @param sysRoleResources
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 11:50:52
     */
    public void saveSysRoleResources(List<SysRoleResource> sysRoleResources){
        sysRoleResourceRepository.insertDataList(sysRoleResources);
    }

    /**
     * @Title:
     * @Description:   删除角色下的对应菜单集合
     * @param sysRoleId
     * @param sysResourceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 11:55:33
     */
    public void deleteSysRoleResources(String sysRoleId,List<String> sysResourceIds){
        if(ArrayUtils.isNotNullAndLengthNotZero(sysResourceIds)){
            Example example = SqlUtil.newExample(SysRoleResource.class);
            example.createCriteria().andEqualTo("roleId",sysRoleId)
                    .andIn("resourceId",sysResourceIds);
            sysRoleResourceRepository.deleteExampleData(example, new SysRoleResource());
        }
    }

}

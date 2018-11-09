package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.pojo.system.entity.SysRoleResource;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleResourceService
 * @Description: 角色菜单关联service
 * @date 2018/3/7
 */
public interface SysRoleResourceService {

    /**
     * @Title:
     * @Description:   批量保存角色菜单
     * @param sysRoleResources
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 11:50:52
     */
    void saveSysRoleResources(List<SysRoleResource> sysRoleResources);

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
    void deleteSysRoleResources(String sysRoleId, List<String> sysResourceIds);

}

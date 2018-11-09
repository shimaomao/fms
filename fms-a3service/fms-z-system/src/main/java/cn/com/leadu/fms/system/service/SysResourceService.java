package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import cn.com.leadu.fms.pojo.system.vo.sysresource.SysResourceVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceDeleteListVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceDeleteVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceModifyVo;
import cn.com.leadu.fms.system.validator.sysresource.vo.SysResourceSaveVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceService
 * @Description: 用户菜单
 * @date 2018/1/14
 */
public interface SysResourceService {

    /**
     * @Title:
     * @Description: 根据用户id返回拥有的菜单
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:48:19
     */
    List<SysResource> findSysResourceByUser(String sysUserId, String validMenuType);

    /**
     * @Title:
     * @Description:  查询所有菜单列表, 根据sort资源排序
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 03:58:27
     */
    List<SysResourceVo> findSysResourceAll();

    /**
     * @Title:
     * @Description: 分页查询菜单 并按录入时间倒序
     * @param sysResourceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:31:12
     */
    PageInfoExtend<SysResource> findSysResourceByPage(SysResourceVo sysResourceVo);

    /**
     * @Title:
     * @Description:  根据角色id获取角色的菜单资源
     * @param sysRoleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 11:39:34
     */
    List<SysResource> findSysResourceBySysRoleId(String sysRoleId);


    /**
     * @Title:
     * @Description: 保存菜单资源
     * @param sysResourceSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:17:25
     */
    void saveSysResource(SysResourceSaveVo sysResourceSaveVo);

    /**
     * @Title:
     * @Description: 修改菜单资源
     * @param sysResourceModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:50:35
     */
    void modifySysResource(SysResourceModifyVo sysResourceModifyVo);


    /**
     * @Title:
     * @Description:  通过id删除菜单资源
     * @param sysResourceDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:55:21
     */
    void deleteSysResource(SysResourceDeleteVo sysResourceDeleteVo);


    /**
     * @Title:
     * @Description:  根据id集合删除菜单资源
     * @param sysResourceDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    void deleteSysResourceByIds(SysResourceDeleteListVo sysResourceDeleteListVo);


    /**
     * @Title:
     * @Description:  根据id获取资源菜单
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:32:58
     */
    SysResource findSysResourceById(String id);

    /**
     * @Title:
     * @Description:  根据菜单级别获取菜单集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/18 10:24:47
     */
    List<SysResource> findSysResourceIsParent(Integer resLevel);

}

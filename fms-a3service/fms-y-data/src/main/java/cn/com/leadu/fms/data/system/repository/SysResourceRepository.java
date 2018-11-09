package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceRepository
 * @Description:
 * @date 2018/1/14
 */
public interface SysResourceRepository {

    /**
     * @Title:
     * @Description: 根据角色id以及资源类型查询菜单资源
     * @param roleIds
     * @param type
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:39:33
     */
    List<SysResource> selectSysResMenusBySysRoleIds(List<String> roleIds,Integer type);

    /**
     * @Title:
     * @Description: 根据用户Id以及资源类型查询资源
     * @param sysUserId
     * @param type
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:39:33
     */
    List<SysResource> selectSysResMenusBySysUserId(String sysUserId, Integer type);

    /**
     * @Title:
     * @Description:  根据条件查询资源
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 03:55:41
     */
    List<SysResource> selectListByExample(Example example);

    /**
     * @Title:
     * @Description: 分页查询
     * @param example,pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:49:17
     */
    PageInfoExtend<SysResource> selectListByExamplePage(Example example, PageQuery pageQuery);

    /**
     * @Title:
     * @Description: 根据角色id获取角色的资源
     * @param sysRoleId
     * @param sysRoleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 11:43:46
     */
    List<SysResource> selectListBySysRoleId(String sysRoleId,Integer type);


    /**
     * @Title:
     * @Description: 保存菜单资源信息
     * @param sysResource
     * @return String
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:26:22
     */
    String insertData(SysResource sysResource);


    /**
     * @Title:
     * @Description:  更新菜单资源
     * @param sysResource
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:16
     */
    void updateByPrimaryKeySelectiveData(SysResource sysResource);



    /**
     * @Title:
     * @Description:  删除资源菜单
     * @param sysResource
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:28
     */
    void deleteData(SysResource sysResource);


    /**
     * @Title:
     * @Description:  根据ids批量删除
     * @param ids
     * @param sysResource
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:28:23
     */
    void deleteDataList(List ids,SysResource sysResource);

    /**
     * @Title:
     * @Description:  根据id获取菜单资源
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:31:34
     */
    SysResource selectByPrimaryKey(Object id);

}

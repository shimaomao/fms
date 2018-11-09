package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceDao
 * @Description:
 * @date 2018/1/14
 */
public interface SysResourceDao extends BaseDao<SysResource> {

    /**
     * @Title:
     * @Description: 根据角色id以及资源类型查询资源
     * @param sysRoleIds
     * @param type
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:39:33
     */
    List<String> selectSysResBySysUserId(@Param("sysRoleIds") List<String> sysRoleIds,@Param("type") String type);


    /**
     * @Title:
     * @Description: 根据角色id以及资源类型查询资源
     * @param sysRoleIds
     * @param type
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 12:39:33
     */
    List<SysResource> selectSysResMenusBySysRoleIds(@Param("sysRoleIds") List<String> sysRoleIds, @Param("type") Integer type);

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
    List<SysResource> selectSysResMenusBySysUserId(@Param("sysUserId") String sysUserId, @Param("type") Integer type);

    /**
     * @Title:
     * @Description: 根据角色id获取角色的资源
     * @param sysRoleId
     * @param type
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 11:43:46
     */
    List<SysResource> selectListBySysRoleId(@Param("sysRoleId")String sysRoleId,@Param("type") Integer type);

}

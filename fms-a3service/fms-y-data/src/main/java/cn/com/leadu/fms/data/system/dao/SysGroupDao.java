package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupDetailVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupDao
 * @Description: 用户组管理dao层
 * @date 2018-03-10
 */
public interface SysGroupDao extends BaseDao<SysGroup> {

    /**
     * @Title:
     * @Description: 分页取得用户组信息
     * @param sysGroupVo 查询参数
     * @return list
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<SysGroupVo> selectSysGroupVosByPage(@Param("sysGroupVo")SysGroupVo sysGroupVo);

    /**
     * @Title:
     * @Description: 分页取得用户组信息
     * @param sysGroupVo 查询参数
     * @return list
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<SysGroupVo> selectSysGroupVoListByPage(@Param("sysGroupVo")SysGroupVo sysGroupVo);

    /**
     * @Title:
     * @Description: 根据用户ID,获取有下级用户组的用户组信息的总件数
     * @param groupIds 查询参数
     * @return long
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    Long selectParentGroupCountByGroupIds(@Param("groupIds")List<String> groupIds);

    /**
     * @Title:
     * @Description: 根据用户组代码,获取上级用户组信息
     * @param groupCode 用户组代码
     * @return long
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    List<SysGroupParentVo> selectParentGroupsByGroup(@Param("groupCode")String groupCode);

    /**
     * @Title:
     * @Description: 根据组织类型，取得用户组信息树
     * @param parentType 组织类型
     * @return List
     * @throws
     * @author wangxue
     * @date 2018-3-13 17:39:58
     */
    List<SysGroupVo> selectSysGroupVosByTree(@Param("parentType")String parentType);

    /**
     * @Title:
     * @Description: 根据用户组ID，取得用户组信息
     * @param groupId 用户组Id
     * @return SysGroupDetailVo
     * @throws
     * @author wangxue
     * @date 2018-3-14 14:39:58
     */
    SysGroupDetailVo selectSysGroupVoByGroupId(@Param("groupId")String groupId);

    /**
     * @Title:
     * @Description: 根据用户组ID，取得用户组信息
     * @param groupIds 用户组Id
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-3-20 14:39:58
     */
    List<String> selectParentIdsByGroupIds(@Param("groupIds")List<String> groupIds);

}
package cn.com.leadu.fms.activiti.service;

import cn.com.leadu.fms.pojo.activiti.entity.ActIdMembership;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActUserGroupService
 * @Description: 工作流用户组service
 * @date 2018/3/12
 */
public interface ActIdMembershipService {

    /**
     * @Title:
     * @Description:   同步用户和他所属的组织机构到工作流用户组中
     * @param: sysUserVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 05:20:46
     */
    void syncSysUsersAndSysOrganizationsToActUserGroups(List<SysUserVo> sysUserVos);

    /**
     * @Title:
     * @Description:   根据用户id和组id获得用户组
     * @param userId
     * @param groupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 06:41:02
     */
    ActIdMembership findActIdMembershipByUserIdAndGroupId(String userId, String groupId);

    /**
     * @Title:
     * @Description:   根据组id查询用户组
     * @param actGroupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:02:23
     */
    List<ActIdMembership> findActIdMembershipsByGroupId(String actGroupId);


    /**
     * @Title:
     * @Description:   根据用户组id返回组下用户id集合
     * @param actGroupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:26:12
     */
    List<String> findActUserIdsByGroupId(String actGroupId);

}

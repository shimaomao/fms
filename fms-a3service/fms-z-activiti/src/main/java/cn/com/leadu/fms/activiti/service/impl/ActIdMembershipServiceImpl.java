package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.activiti.service.ActIdMembershipService;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.activiti.repository.ActIdMembershipRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.activiti.entity.ActIdMembership;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import org.activiti.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActUserGroupServiceImpl
 * @Description: 工作流用户组service实现类
 * @date 2018/3/12
 */
@Service
public class ActIdMembershipServiceImpl implements ActIdMembershipService {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private ActIdMembershipRepository actIdMembershipRepository;

    /**
     * @Title:
     * @Description:   同步用户和他所属的组织机构到工作流用户组中
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 05:20:46
     */
    /**
     * @Title:
     * @Description:   同步用户和他所属的组织机构到工作流用户组中
     * @param: sysUserVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 05:20:46
     */
    @Transactional
    public void syncSysUsersAndSysOrganizationsToActUserGroups(List<SysUserVo> sysUserVos){
        createActUserGroups(sysUserVos);
    }

    /**
     * @Title:
     * @Description:   通过系统用户和所在组织创建用户组
     * @param sysUserVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 06:04:32
     */
    private void createActUserGroups(List<SysUserVo> sysUserVos){
        if(ArrayUtils.isNotNullAndLengthNotZero(sysUserVos))
            for(SysUserVo sysUserVo : sysUserVos)
                createActUserGroup(sysUserVo);
    }

    /**
     * @Title:
     * @Description:   通过系统用户和所在组织创建用户组
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 06:04:32
     */
    private void createActUserGroup(SysUserVo sysUserVo){

    }

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
    public ActIdMembership findActIdMembershipByUserIdAndGroupId(String userId,String groupId){
        Example example = SqlUtil.newExample(ActIdMembership.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("groupId",groupId);
        return actIdMembershipRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:   根据组id查询用户组
     * @param actGroupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:02:23
     */
    public List<ActIdMembership> findActIdMembershipsByGroupId(String actGroupId){
        Example example = SqlUtil.newExample(ActIdMembership.class);
        example.createCriteria().andEqualTo("groupId",actGroupId);
        return actIdMembershipRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:   根据用户组id返回组下用户id集合
     * @param actGroupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:26:12
     */
    public List<String> findActUserIdsByGroupId(String actGroupId){
        return actIdMembershipRepository.selectActUserIdsByActGroupId(actGroupId);
    }

}

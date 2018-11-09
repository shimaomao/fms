package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.*;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.pojo.system.entity.*;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.system.service.SysGroupParentService;
import cn.com.leadu.fms.system.service.SysGroupService;
import cn.com.leadu.fms.system.service.SysMenuService;
import cn.com.leadu.fms.system.service.SysUserService;
import cn.com.leadu.fms.system.validator.sysuser.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

import static cn.com.leadu.fms.common.constant.enums.system.SysUserValidMenuTypeEnums.USER_CONTROLLER;

/**
 * @author ningyangyang
 * @ClassName: SysUserServiceImpl
 * @Description: 用户业务层
 * @date 2018/1/12
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysGroupService sysGroupService;

    @Autowired
    private SysUserMenuRepository sysUserMenuRepository;

    @Autowired
    private SysGroupRepository sysGroupRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private SysGroupParentService sysGroupParentService;
    /**
     * @Title:
     * @Description: 保存用户
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:17:25
     */
    @Transactional
    public void saveSysUser(SysUserSaveVo sysUserVo) {
        SysUser sysUser = sysUserVo.getEntity();
        sysUser.setUserPassword(passwordEncoder.encode(sysUser.getUserPassword()));
        String userId =  sysUserRepository.insertData(sysUser);
        List<SysRole> roleList = sysUserVo.getRoles();
        List<SysUserRole>  userRoleList = new ArrayList<>();
        for(SysRole role : roleList){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(role.getRoleId());
            userRoleList.add(sysUserRole);
        }
        sysUserRoleRepository.insertDataList(userRoleList);
    }


    /**
     * @Title:
     * @Description: 根据用户名,手机号分页查询用户 并按录入时间倒序
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:31:12
     */
    public PageInfoExtend<SysUser> findSysUserByPage(SysUserVo sysUserVo){
        Example example = SqlUtil.newExample(SysUser.class);
        PageInfoExtend<SysUser> pageInfo = sysUserRepository.selectListByExamplePage(example,sysUserVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 修改用户
     * @param sysUserModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:50:35
     */
    @Override
    @Transactional
    public void modifySysUser(SysUserModifyVo sysUserModifyVo) {
        SysUser sysUser = sysUserModifyVo.getEntity();
        SysUser oldSysUser =  sysUserRepository.selectByPrimaryKey(sysUserModifyVo.getUserId());
        if(oldSysUser.getUserPassword().equals(sysUserModifyVo.getUserPassword())){
            sysUser.setUserPassword(null);
        }else{
            sysUser.setUserPassword(passwordEncoder.encode(sysUser.getUserPassword()));
        }
        sysUserRepository.updateByPrimaryKeySelectiveData(sysUser);
        Example example  = SqlUtil.newExample(SysUserRole.class);
        example.createCriteria().andEqualTo("userId",sysUserModifyVo.getUserId());
        sysUserRoleRepository.deleteExampleData(example,new SysUserRole());
        //更新角色
        List<SysRole> roleList = sysUserModifyVo.getRoles();
        List<SysUserRole>  userRoleList = new ArrayList<>();
        for(SysRole role : roleList){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(sysUserModifyVo.getUserId());
            sysUserRole.setRoleId(role.getRoleId());
            userRoleList.add(sysUserRole);
        }
        sysUserRoleRepository.insertDataList(userRoleList);
    }

    /**
     * @Title:
     * @Description:  通过id删除用户
     * @param sysUserDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:55:21
     */
    @Override
    @Transactional
    public void deleteSysUser(SysUserDeleteVo sysUserDeleteVo) {
        sysUserRepository.deleteData(sysUserDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据id获取用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:32:58
     */
    public SysUser findSysUserById(String id){
        return sysUserRepository.selectByPrimaryKey(id);
    }

    /**
     * @Title:
     * @Description:  根据用户名获取用户
     * @param username
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/12 12:37:31
     */
    public SysUser findSysUserByUsername(String username){
        if(StringUtils.isNotTrimBlank(username)) {
            Example example = SqlUtil.newExample(SysUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("user", username);
            return sysUserRepository.selectOneByExample(example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  获取当前登录用户的详细信息
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 02:26:33
     */
    public SysUserVo findSysUserDetail(SysUser sysUser){
        SysUserVo sysUserVo = new SysUserVo();
        BeanUtils.copyProperties(sysUser,sysUserVo);
        sysUserVo.setSysMenus(sysMenuService.findSysMenusByUserId(sysUser.getUserId(), sysUser.getValidMenuType()));
        sysUserVo.setRoles(sysUserRepository.selectSysUserVoById(sysUser.getUserId()).getRoles());
        return sysUserVo;
    }

    /**
     * @Title:
     * @Description:   根据id集合删除用户
     * @param sysUserDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @Transactional
    public void deleteSysUserByIds(SysUserDeleteListVo sysUserDeleteListVo, @AuthUserInfo SysUser sysUser){

        for(String userId :sysUserDeleteListVo.getUserIds()){
            if(userId.equals(sysUser.getUserId())){
                throw  new FmsServiceException("当前登录用户不可删除");
            }
        }

        Example ex1 = SqlUtil.newExample(SysUserMenu.class);
        for(String userId :sysUserDeleteListVo.getUserIds()){
            ex1.createCriteria().andEqualTo("userId",userId);
            sysUserMenuRepository.deleteExampleData(ex1,new SysUserMenu());
        }
        Example example  = SqlUtil.newExample(SysUserRole.class);
        for(String userId :sysUserDeleteListVo.getUserIds()){
            example.createCriteria().andEqualTo("userId",userId);
            sysUserRoleRepository.deleteExampleData(example,new SysUserRole());
        }
        sysUserRepository.deleteDataList(sysUserDeleteListVo.getUserIds(),sysUserDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:   修改用户密码
     * @param sysUserModifyPwdVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/19 06:00:46
     */
    @Transactional
    public void modifySysUserPwd(SysUserModifyPwdVo sysUserModifyPwdVo){
        SysUser sysUser = sysUserModifyPwdVo.getEntity();
        sysUser.setUserPassword(passwordEncoder.encode(sysUser.getUserPassword()));
        sysUserRepository.updateByPrimaryKeySelectiveData(sysUser);
    }

    /**
     * @Title:
     * @Description:   根据用户id获取用户vo详细信息
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/01 09:59:08
     */
    public SysUserVo findSysUserVoById(String id){
        SysUserVo  sysUserVo =  sysUserRepository.selectSysUserVoById(id);
        if(sysGroupService.findSysGroupByGroup(sysUserVo.getGroupCode())!=null)
            sysUserVo.setGroupName(sysGroupService.findSysGroupByGroup(sysUserVo.getGroupCode()).getGroupName());

        return sysUserVo;
    }

    /**
     * @Title:
     * @Description: 根据用户名,用户代码分页查询用户 并按录入时间倒序
     * @param sysUserVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/01/09 04:31:12
     */
    public PageInfoExtend<SysUserVo> findSysUserVoByPage(SysUserVo sysUserVo){

        if(StringUtils.isNotTrimBlank(sysUserVo.getUser()))
            sysUserVo.setUser(SqlUtil.likePattern(sysUserVo.getUser()));
        else
            sysUserVo.setUser(null);
        if(StringUtils.isNotTrimBlank(sysUserVo.getUserName()))
            sysUserVo.setUserName(SqlUtil.likePattern(sysUserVo.getUserName()));
        else
            sysUserVo.setUserName(null);

        Example example  = SqlUtil.newExample(SysGroup.class);
        if(StringUtils.isNotTrimBlank(sysUserVo.getGroupName())){
            example.createCriteria().andLike("groupName",SqlUtil.likePattern(sysUserVo.getGroupName()));
            List<SysGroup> groupList =   sysGroupRepository.selectListByExample(example);
            if(ArrayUtils.isNotNullAndLengthNotZero(groupList)){
                List<String> groupCodesList = new ArrayList<>();
                for(SysGroup sysGroup:groupList){
                    groupCodesList.add(sysGroup.getGroupCode());
                }
                sysUserVo.setGroupCodes(groupCodesList);
            }  else{
                return PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,sysUserVo.getPageQuery(),SysUserVo.class);
            }
        }
        else{
            sysUserVo.setGroupCodes(null);
        }


        Example ex2 = SqlUtil.newExample(SysRole.class);
        if(StringUtils.isNotTrimBlank(sysUserVo.getRoleName()) || StringUtils.isNotTrimBlank(sysUserVo.getRole())  ){ //角色信息入力
            Set userSet = new HashSet();
            Example.Criteria criteria = ex2.createCriteria();
            if(StringUtils.isNotTrimBlank(sysUserVo.getRoleName()))
                criteria.andLike("roleName",SqlUtil.likePattern(sysUserVo.getRoleName()));
            if(StringUtils.isNotTrimBlank(sysUserVo.getRole()))
                criteria.andEqualTo("role",sysUserVo.getRole());
            List<SysRole> roleList =   sysRoleRepository.selectListByExample(ex2);
            if(ArrayUtils.isNotNullAndLengthNotZero(roleList)){
                for(SysRole sysRole:roleList){
                    Example ex3 = SqlUtil.newExample(SysUserRole.class);
                    ex3.createCriteria().andEqualTo("roleId",sysRole.getRoleId());
                    List<SysUserRole> userRoleList = sysUserRoleRepository.selectListByExample(ex3);
                    if(ArrayUtils.isNotNullAndLengthNotZero(userRoleList)){
                        for(SysUserRole sysUserRole:userRoleList){
                            userSet.add(sysUserRole.getUserId());
                        }
                    }else{
                        return PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,sysUserVo.getPageQuery(),SysUserVo.class);
                    }
                }
            }else {
                return PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,sysUserVo.getPageQuery(),SysUserVo.class);
            }
            if(userSet.size()!=0){
                List<String> userIds = new ArrayList<>();
                Iterator<String> it = userSet.iterator();
                while (it.hasNext()){
                    userIds.add(it.next());
                }
                sysUserVo.setUserIds(userIds);
            }
        }else
            sysUserVo.setUserIds(null);

        PageInfoExtend<SysUserVo>  pageList =  sysUserRepository.selectSysUserVoByPage(sysUserVo,sysUserVo.getPageQuery());
        List<SysUserVo> userList = pageList.getData();
        for(SysUserVo sysUser:userList){
            if(sysGroupService.findSysGroupByGroup(sysUser.getGroupCode())!=null)
                sysUser.setGroupName(sysGroupService.findSysGroupByGroup(sysUser.getGroupCode()).getGroupName());
        }
        pageList.setData(userList);
        return pageList;
    }

    /**
     * @Title:
     * @Description:   获取所有用户,通过添加时间倒序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 04:22:41
     */
    public List<SysUserVo> findSysUserVosAndSysOrganizationsByAll(){
        List<SysUserVo> sysUserVos = new ArrayList<>();
        Example example = SqlUtil.newExample(SysUser.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        List<SysUser> sysUsers = sysUserRepository.selectListByExample(example);
        return sysUserVos;
    }

    /**
     * @Title:
     * @Description:   根据组织机构code查询用户登录名集合
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    public List<String> findSysUserLoginNamesByGroupCode(String groupCode){
        List<String> sysUserLoginNames = sysUserRepository.selectSysUserLoginNamesByGroupCode(groupCode);
        return sysUserLoginNames;
    }

    /**
     * @Title:
     * @Description:   根据组织机构code集合查询用户登录名集合
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    public List<String> findSysUserLoginNamesByGroupCodes(List<String> groupCodes){
        if(ArrayUtils.isNullOrLengthZero(groupCodes))
            return null;
        List<String> sysUserLoginNames = sysUserRepository.selectSysUserLoginNamesByGroupCodes(groupCodes);
        return sysUserLoginNames;
    }


    /**
     * @Title:
     * @Description:  更新用户最后登录时间
     * @param user
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/4 13:46:05
     */
    @Override
    public void modifyLastLoginTime(String user) {
        // 根据用户登录账号，更新用户最后登录时间
        SysUser sysUser = new SysUser();
        sysUser.setLastLoginTime(new Date());
        Example example = SqlUtil.newExample(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("user", user);
        sysUserRepository.updateByExampleSelectiveData(sysUser, example);
    }

    /**
     * 根据菜单控制权限找到所有用户
     * @return
     */
    @Override
    public List<SysUser> findAllUsers() {
        Example example = SqlUtil.newExample(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("validMenuType",USER_CONTROLLER.getType());
        return sysUserRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param role
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    public List<String> findSysUserLoginNamesByRole(String role){
        return sysUserRepository.selectSysUserLoginNamesByRole(role);
    }

    /**
     * @Title:
     * @Description:   根据roleId集合查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    public List<String> findSysUserLoginNamesByRoles(List<String> roles){
        if(ArrayUtils.isNullOrLengthZero(roles))
            return null;
        return sysUserRepository.selectSysUserLoginNamesByRoles(roles);
    }

    /**
     * @param roles
     * @param groupCode
     * @Description: 根据roleId集合和组织机构代码（当前机构没有则向上级查询）查询用户登录名集合
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/12 15:15
     */
    @Override
    public List<String> findSysUserLoginNamesByRolesWithGroupCode(List<String> roles, String groupCode) {
        if(ArrayUtils.isNullOrLengthZero(roles) || StringUtils.isTrimBlank(groupCode))
            return null;
        List<String> userNameList = sysUserRepository.findSysUserLoginNamesByRolesWithGroupCode(roles,groupCode);
        if(ArrayUtils.isNullOrLengthZero(userNameList)){//如果未查询到，向上级用户组查询
            String groupCodeParent = "";
            SysGroupParent sysGroupParent = sysGroupParentService.findSysGroupParentsByGroupCode(groupCode);
            if(sysGroupParent != null){
                groupCodeParent = sysGroupParent.getParentGroup();
            }
            return this.findSysUserLoginNamesByRolesWithGroupCode(roles, groupCodeParent);
        }
        return userNameList;
    }

    /**
     * @Title:
     * @Description:   根据用户组ID集合获取用户登录名
     * @param groupIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/26 04:51:56
     */
    @Override
    public List<String> findSysUserLoginNamesByGroupIds(List<String> groupIds) {
        return sysUserRepository.selectSysUserNameByGroupIds(groupIds);
    }
}

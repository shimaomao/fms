package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.system.dao.SysUserDao;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: qiaohao
 * Date: 2018/1/4
 * Time: 下午4:13
 * Description:
 */
@Repository
public class SysUserRepositoryImpl extends AbstractBaseRepository<SysUserDao,SysUser> implements SysUserRepository {

    /**
     * @Title:
     * @Description: 保存用户信息
     * @param sysUser
     * @return String
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:26:22
     */
    @Override
    public String insertData(SysUser sysUser){
        super.insert(sysUser);
        return sysUser.getUserId();
    }


    /**
     * @Title:
     * @Description:  通过条件批量查询
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:23:21
     */
    @Override
    public List<SysUser> selectListByExample(Example example){
        return super.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 分页查询
     * @param example,pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:49:17
     */
    public PageInfoExtend<SysUser> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description:  更新用户
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:16
     */
    @Override
    public void updateByPrimaryKeySelectiveData(SysUser sysUser) {
        super.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改用户
     * @param sysUser
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-4-4 15:16:18
     */
    @Override
    public int updateByExampleSelectiveData(SysUser sysUser, Example example) {
        return super.updateByExampleSelective(sysUser, example);
    }

    /**
     * @Title:
     * @Description:  删除用户
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:28
     */
    @Override
    public void deleteData(SysUser sysUser) {
        super.delete(sysUser);
    }

    /**
     * @Title:
     * @Description:  根据id获取用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:31:34
     */
    @Override
    public SysUser selectByPrimaryKey(Object id){
        return super.selectByPrimaryKey(id);
    }

    /**
     * @Title:
     * @Description:  根据ids批量删除
     * @param ids
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:28:23
     */
    public void deleteDataList(List ids,SysUser sysUser){
        super.deleteByIds(ids,sysUser);
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
    public SysUserVo selectSysUserVoById(Object id){
        return baseDao.selectSysUserVoById(id);
    }

    /**
     * @Title:
     * @Description:   分页查询用户vo
     * @param sysUserVo
     * @param pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/12 04:48:41
     */
    public PageInfoExtend selectSysUserVoByPage(SysUserVo sysUserVo,PageQuery pageQuery){
        return super.selectListVoByPage("selectSysUserVoByPage",sysUserVo,pageQuery);
    }

    /**
     * @Title:
     * @Description:   根据groupCode查询用户登录名集合
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:41:50
     */
    public List<String> selectSysUserLoginNamesByGroupCode(String groupCode){
        return baseDao.selectSysUserLoginNamesByGroupCode(groupCode);
    }

    /**
     * @Title:
     * @Description:   根据groupCode集合查询用户登录名集合
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:41:50
     */
    public List<String> selectSysUserLoginNamesByGroupCodes(List<String> groupCodes){
        return baseDao.selectSysUserLoginNamesByGroupCodes(groupCodes);
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
    public List<String> selectSysUserLoginNamesByRole(String role){
        return baseDao.selectSysUserLoginNamesByRole(role);
    }

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    public List<String> selectSysUserLoginNamesByRoles(List<String> roles){
        return baseDao.selectSysUserLoginNamesByRoles(roles);
    }

    /**
     * @param roles
     * @param groupCode
     * @Description: 根据roleId集合和组织机构代码查询用户登录名集合
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/12 15:30
     */
    @Override
    public List<String> findSysUserLoginNamesByRolesWithGroupCode(List<String> roles, String groupCode) {
        return baseDao.findSysUserLoginNamesByRolesWithGroupCode(roles,groupCode);
    }

    /**
     * @Title:
     * @Description:  根据用户组ID集合获取用户登录名
     * @param groupIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/26 04:51:56
     */
    @Override
    public List<String> selectSysUserNameByGroupIds(List<String> groupIds) {
        return baseDao.selectSysUserNameByGroupIds(groupIds);
    }

    /**
     * @Title:
     * @Description: 通过条件查询一个用户
     * @param example
     * @return SysUser
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public SysUser selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * 根据账号获取用户所属角色List
     */
    @Override
    public List<String> selectRolesByUser(String user) {
        return baseDao.selectRolesByUser(user);
    }
}

package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleRepository
 * @Description: 角色Repository
 * @date 2018/1/12
 */
public interface SysRoleRepository {

    /**
     * @Title:
     * @Description: 保存角色信息
     * @param sysRole
     * @return String
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:26:22
     */
    String insertData(SysRole sysRole);

    /**
     * @Title:
     * @Description:  通过条件批量查询
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:23:21
     */
    List<SysRole> selectListByExample(Example example);

    /**
     * @Title:
     * @Description: 分页查询
     * @param example,pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:49:17
     */
    PageInfoExtend<SysRole> selectListByExamplePage(Example example, PageQuery pageQuery);

    /**
     * @Title:
     * @Description:  更新角色
     * @param sysRole
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:16
     */
    void updateByPrimaryKeySelectiveData(SysRole sysRole);

    /**
     * @Title:
     * @Description:  删除角色
     * @param sysRole
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:28
     */
    void deleteData(SysRole sysRole);


    /**
     * @Title:
     * @Description:  根据id获取角色
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:31:34
     */
    SysRole selectByPrimaryKey(Object id);


    /**
     * @Title:
     * @Description:  根据用户id获取对应的角色id集合
     * @param userId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 01:00:27
     */
    List<String> selectSysRoleIdsBySysUserId(String userId);


    /**
     * @Title:
     * @Description:  根据ids批量删除
     * @param ids
     * @param sysRole
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:28:23
     */
    void deleteDataList(List ids,SysRole sysRole);

    /**
     * @Title:
     * @Description:   根据用户id查询拥有角色集合
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 01:57:26
     */
    List<SysRole> selectSysRolesBySysUserId(String sysUserId);

    /**
     * 找到所有角色
     * @return
     */
    List<SysRole> findAllRoles();
}

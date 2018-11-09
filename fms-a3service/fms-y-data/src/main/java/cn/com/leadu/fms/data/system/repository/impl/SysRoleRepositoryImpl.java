package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.system.dao.SysRoleDao;
import cn.com.leadu.fms.data.system.repository.SysRoleRepository;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleRepositoryImpl
 * @Description: 角色repository
 * @date 2018/1/12
 */
@Repository
public class SysRoleRepositoryImpl extends AbstractBaseRepository<SysRoleDao,SysRole> implements SysRoleRepository {

    /**
     * @Title:
     * @Description: 保存角色信息
     * @param sysRole
     * @return String
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:26:22
     */
    public String insertData(SysRole sysRole){
        super.insert(sysRole);
        return sysRole.getRoleId();
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
    public List<SysRole> selectListByExample(Example example){
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
    public PageInfoExtend<SysRole> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description:  更新角色
     * @param sysRole
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:16
     */
    public void updateByPrimaryKeySelectiveData(SysRole sysRole){
        super.updateByPrimaryKeySelective(sysRole);
    }

    /**
     * @Title:
     * @Description:  删除角色
     * @param sysRole
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:28
     */
    public void deleteData(SysRole sysRole){
        super.delete(sysRole);
    }

    /**
     * @Title:
     * @Description:  根据id获取角色
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:31:34
     */
    public SysRole selectByPrimaryKey(Object id){
        return super.selectByPrimaryKey(id);
    }


    /**
     * @Title:
     * @Description:  根据用户id获取对应的角色id集合
     * @param userId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 01:00:27
     */
    public List<String> selectSysRoleIdsBySysUserId(String userId){
        return baseDao.selectSysRoleIdsBySysUserId(userId);
    }

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
    public void deleteDataList(List ids,SysRole sysRole){
        super.deleteByIds(ids,sysRole);
    }

    /**
     * @Title:
     * @Description:   根据用户id查询拥有角色集合
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 01:57:26
     */
    public List<SysRole> selectSysRolesBySysUserId(String sysUserId){
        return baseDao.selectSysRolesBySysUserId(sysUserId);
    }

    /**
     * 找到所有角色
     * @return
     */
    @Override
    public List<SysRole> findAllRoles() {
        return super.selectAll();
    }

}

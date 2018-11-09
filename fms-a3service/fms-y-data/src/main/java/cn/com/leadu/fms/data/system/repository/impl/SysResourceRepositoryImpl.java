package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.system.dao.SysResourceDao;
import cn.com.leadu.fms.data.system.repository.SysResourceRepository;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceRepositoryImpl
 * @Description:
 * @date 2018/1/14
 */
@Repository
public class SysResourceRepositoryImpl extends AbstractBaseRepository<SysResourceDao,SysResource> implements SysResourceRepository {

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
    public List<SysResource> selectSysResMenusBySysRoleIds(List<String> roleIds,Integer type){
        return baseDao.selectSysResMenusBySysRoleIds(roleIds,type);
    }

    @Override
    public List<SysResource> selectSysResMenusBySysUserId(String sysUserId, Integer type) {
        return null;
    }

    /**
     * @Title:
     * @Description:  根据条件查询资源
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 03:55:41
     */
    public List<SysResource> selectListByExample(Example example){
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
    public PageInfoExtend<SysResource> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

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
    public List<SysResource> selectListBySysRoleId(String sysRoleId,Integer type){
        return baseDao.selectListBySysRoleId(sysRoleId,type);
    }

    /**
     * @Title:
     * @Description: 保存菜单资源信息
     * @param sysResource
     * @return String
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:26:22
     */
    public String insertData(SysResource sysResource){
        super.insert(sysResource);
        return sysResource.getId();
    }


    /**
     * @Title:
     * @Description:  更新菜单资源
     * @param sysResource
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:16
     */
    public void updateByPrimaryKeySelectiveData(SysResource sysResource){
        super.updateByPrimaryKeySelective(sysResource);
    }


    /**
     * @Title:
     * @Description:  删除资源菜单
     * @param sysResource
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:28
     */
    public void deleteData(SysResource sysResource){
        super.delete(sysResource);
    }

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
    public void deleteDataList(List ids,SysResource sysResource){
        super.deleteByIds(ids,sysResource);
    }


    /**
     * @Title:
     * @Description:  根据id获取菜单资源
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:31:34
     */
    public SysResource selectByPrimaryKey(Object id){
        return super.selectByPrimaryKey(id);
    }



}

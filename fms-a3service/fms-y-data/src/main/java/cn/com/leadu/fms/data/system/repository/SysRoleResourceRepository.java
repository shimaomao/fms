package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysRoleResource;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleResourceRepository
 * @Description:
 * @date 2018/1/14
 */
public interface SysRoleResourceRepository {


    /**
     * @Title:
     * @Description:  批量保存角色资源
     * @param sysRoleResources
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 06:04:42
     */
    List<SysRoleResource> insertDataList(List<SysRoleResource> sysRoleResources);


    /**
     * @Title:
     * @Description:  根据id列表和角色id删除
     * @param example
     * @param sysRoleResource
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 02:37:31
     */
    void deleteExampleData(Example example,SysRoleResource sysRoleResource);

}

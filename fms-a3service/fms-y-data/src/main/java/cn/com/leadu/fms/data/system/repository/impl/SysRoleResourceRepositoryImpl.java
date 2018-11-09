package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.system.dao.SysRoleResourceDao;
import cn.com.leadu.fms.data.system.repository.SysRoleResourceRepository;
import cn.com.leadu.fms.pojo.system.entity.SysRoleResource;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleResourceRepositoryImpl
 * @Description:
 * @date 2018/1/14
 */
@Repository
public class SysRoleResourceRepositoryImpl extends AbstractBaseRepository<SysRoleResourceDao,SysRoleResource> implements SysRoleResourceRepository {

    /**
     * @Title:
     * @Description:  批量保存角色资源
     * @param sysRoleResources
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 06:04:42
     */
    public List<SysRoleResource> insertDataList(List<SysRoleResource> sysRoleResources){
        super.insertListByJdbcTemplate(sysRoleResources);
        return sysRoleResources;
    }

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
    public void deleteExampleData(Example example,SysRoleResource sysRoleResource){
        super.deleteByExample(example,sysRoleResource);
    }

}

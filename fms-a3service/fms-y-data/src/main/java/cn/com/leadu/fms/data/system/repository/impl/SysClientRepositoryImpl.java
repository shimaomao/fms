package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.system.dao.SysClientDao;
import cn.com.leadu.fms.data.system.repository.SysClientRepository;
import cn.com.leadu.fms.pojo.system.entity.SysClient;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

/**
 * @author qiaomengnan
 * @ClassName: SysClientRepositoryImpl
 * @Description: 客户端标识 repository 实现类
 * @date 2018/3/6
 */
@Repository
public class SysClientRepositoryImpl extends AbstractBaseRepository<SysClientDao,SysClient> implements SysClientRepository {

    /**
     * @Title:
     * @Description:   通过组合条件查询一条信息
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 06:40:50
     */
    public SysClient selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

}

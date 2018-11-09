package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysClient;
import tk.mybatis.mapper.entity.Example;

/**
 * @author qiaomengnan
 * @ClassName: SysClientRepository
 * @Description: 客户端标识 repository
 * @date 2018/3/6
 */
public interface SysClientRepository {

    /**
     * @Title:
     * @Description:   通过组合条件查询一条信息
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 06:40:50
     */
    SysClient selectOneByExample(Example example);

}

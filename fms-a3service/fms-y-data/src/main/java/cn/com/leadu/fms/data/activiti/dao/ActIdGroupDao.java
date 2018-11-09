package cn.com.leadu.fms.data.activiti.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.activiti.entity.ActIdGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdGroupDao
 * @Description: 用户组dao
 * @date 2018/6/19
 */
public interface ActIdGroupDao extends BaseDao<ActIdGroup> {

    /**
     * @Title:
     * @Description: 根据用户查询到用户所在的组id
     * @param user
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    List<String> selectActIdGroupIdsByUser(@Param("user") String user);

}

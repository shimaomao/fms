package cn.com.leadu.fms.data.activiti.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.activiti.entity.ActIdMembership;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdMembershipDao
 * @Description: 工作流用户组dao
 * @date 2018/3/12
 */
public interface ActIdMembershipDao extends BaseDao<ActIdMembership> {

    /**
     * @Title:
     * @Description:   根据用户组id返回用户id
     * @param actGroupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:26:12
     */
    List<String> selectActUserIdsByActGroupId(@Param("actGroupId") String actGroupId);

}

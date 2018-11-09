package cn.com.leadu.fms.data.activiti.repository;

import cn.com.leadu.fms.pojo.activiti.entity.ActIdMembership;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdMembershipRepository
 * @Description: 工作流用户组repository
 * @date 2018/3/12
 */
public interface ActIdMembershipRepository {

    /**
     * @Title:
     * @Description:   根据条件返回一个实体
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 06:33:43
     */
    ActIdMembership selectOneByExample(Example example);


    /**
     * @Title:
     * @Description:   根据条件返回列表
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:08:09
     */
    List<ActIdMembership> selectListByExample(Example example);

    /**
     * @Title:
     * @Description:   根据用户组id返回用户id
     * @param actGroupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:26:12
     */
    List<String> selectActUserIdsByActGroupId(String actGroupId);

}

